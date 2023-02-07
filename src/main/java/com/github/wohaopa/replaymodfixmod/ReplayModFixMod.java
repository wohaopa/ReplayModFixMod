package com.github.wohaopa.replaymodfixmod;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;

@Mod(
        modid = ReplayModFixMod.MODID,
        name = ReplayModFixMod.NAME,
        version = ReplayModFixMod.VERSION,
        dependencies = "required-after:spongemixins;")
public class ReplayModFixMod {

    public static final Logger LOG = LogManager.getLogManager().getLogger("ReplayModFixMod");

    public static final String MODID = "replaymodfixmod";
    public static final String NAME = "ReplayMod Fix Mod";
    public static final String VERSION = "1.0.1";
    @Mod.Instance(MODID)
    public static ReplayModFixMod instance;

}
