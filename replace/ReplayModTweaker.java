package com.replaymod.core.tweaker;

import com.replaymod.extras.modcore.ModCoreInstaller;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;
import org.spongepowered.asm.launch.platform.container.ContainerHandleURI;

public class ReplayModTweaker implements ITweaker {
    private static final String MIXIN_TWEAKER = "org.spongepowered.asm.launch.MixinTweaker";

    public ReplayModTweaker() {
        injectMixinTweaker();
    }

    private void injectMixinTweaker() {
        List<String> tweakClasses = (List<String>)Launch.blackboard.get("TweakClasses");
        if (tweakClasses.contains("org.spongepowered.asm.launch.MixinTweaker"))
            return;
        if (GlobalProperties.get(GlobalProperties.Keys.INIT) != null)
            return;
        System.out.println("Injecting MixinTweaker from ReplayModTweaker");
        Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.launch.MixinTweaker".substring(0, "org.spongepowered.asm.launch.MixinTweaker".lastIndexOf('.')));
        List<ITweaker> tweaks = (List<ITweaker>)Launch.blackboard.get("Tweaks");
        try {
            tweaks.add((ITweaker)Class.forName("org.spongepowered.asm.launch.MixinTweaker", true, (ClassLoader)Launch.classLoader).newInstance());
        } catch (InstantiationException|IllegalAccessException|ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {}

    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        URI uri;
        try {
            uri = getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        MixinPlatformManager platform = MixinBootstrap.getPlatform();
        platform.addContainer(new ContainerHandleURI(uri));
    }

    public String getLaunchTarget() {
        return null;
    }

    public String[] getLaunchArguments() {
        return new String[0];
    }

    private void initModCore(String mcVer) {
        try {
            if (System.getProperty("REPLAYMOD_SKIP_MODCORE", "false").equalsIgnoreCase("true")) {
                System.out.println("ReplayMod not initializing ModCore because REPLAYMOD_SKIP_MODCORE is true.");
                return;
            }
            if (((Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment")).booleanValue()) {
                System.out.println("ReplayMod not initializing ModCore because we're in a development environment.");
                return;
            }
            int result = ModCoreInstaller.initialize(Launch.minecraftHome, mcVer + "_forge");
            if (result != -2)
                System.out.println("ReplayMod ModCore init result: " + result);
            if (ModCoreInstaller.isErrored())
                System.err.println(ModCoreInstaller.getError());
        } catch (Throwable t) {
            System.err.println("ReplayMod caught error during ModCore init:");
            t.printStackTrace();
        }
    }
}
