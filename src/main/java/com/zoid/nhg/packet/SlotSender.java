package com.zoid.nhg.packet;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSetSlot;
import org.jetbrains.annotations.NotNull;

public final class SlotSender {
    private SlotSender() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static void sendSlot(
            final @NotNull User user,
            final int windowId,
            final int slotIndex,
            final @NotNull ItemStack item
    ) {
        final WrapperPlayServerSetSlot packet = new WrapperPlayServerSetSlot(
                windowId,
                0,
                slotIndex,
                item
        );
        user.sendPacket(packet);
    }
}