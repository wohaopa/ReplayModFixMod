package com.github.wohaopa.replaymodfixmod.mixins;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetHandlerPlayClient.class)
public abstract class NetHandlerPlayClientMixin {

    @Inject(method = "handleSpawnPlayer", at = @At("HEAD"), cancellable = true)
    public void inject(S0CPacketSpawnPlayer p_147237_1_, CallbackInfo ci) {
        if (((NetHandlerPlayClient) (Object) this).gameController.theWorld == null) {
            ci.cancel();
            System.out.println("Wrong packet: " + p_147237_1_);
        }
        System.out.println("[RM-fix]S0C injected!" + p_147237_1_);
    }
}
