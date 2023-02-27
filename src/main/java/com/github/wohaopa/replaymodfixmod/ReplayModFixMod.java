package com.github.wohaopa.replaymodfixmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;

@Mod(
        modid = ReplayModFixMod.MODID,
        name = ReplayModFixMod.NAME,
        version = ReplayModFixMod.VERSION,
         dependencies = "required-before:replaymod;required-after:spongemixins;")
//        dependencies = "required-after:spongemixins;")
public class ReplayModFixMod {

    public static final Logger LOG = LogManager.getLogger("replaymod fix mod");

    public static final String MODID = "replaymodfixmod";
    public static final String NAME = "ReplayMod Fix Mod";
    public static final String VERSION = "1.0.1";
    @Mod.Instance(MODID)
    public static ReplayModFixMod instance;

}
