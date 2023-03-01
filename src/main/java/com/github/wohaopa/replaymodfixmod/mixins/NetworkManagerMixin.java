package com.github.wohaopa.replaymodfixmod.mixins;

import net.minecraft.network.INetHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.github.wohaopa.replaymodfixmod.ReplayModFixMod;

@Mixin(NetworkManager.class)
public abstract class NetworkManagerMixin {

    @Redirect(
            method = "processReceivedPackets",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/network/Packet;func_148833_a(Lnet/minecraft/network/INetHandler;)V",
                    remap = false))
    private void inject(Packet packet, INetHandler netHandler) {

        try {
            packet.processPacket(netHandler);
        } catch (NullPointerException e) {
            if (e == null) {
                ReplayModFixMod.LOG.log(Level.ERROR, "I don't known!");
                return;
            }
            ReplayModFixMod.LOG.log(Level.ERROR, "NPE!: %s" + packet.getClass().getName());
            ReplayModFixMod.LOG.catching(e);
        }
    }
}
