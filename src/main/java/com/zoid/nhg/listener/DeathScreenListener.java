package com.zoid.nhg.listener;

import com.zoid.nhg.NoHandGhosts;
import com.zoid.nhg.packet.SlotSender;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import io.github.retrooper.packetevents.util.folia.FoliaScheduler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

public final class DeathScreenListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(final @NotNull PlayerDeathEvent event) {
        final Player player = event.getPlayer();
        if (!player.isOnline()) {
            return;
        }

        final var user = PacketEvents.getAPI().getPlayerManager().getUser(player);

        FoliaScheduler.getEntityScheduler().execute(
                player,
                NoHandGhosts.instance,
                () -> {
                    SlotSender.sendSlot(user, 0, player.getInventory().getHeldItemSlot() + 36, ItemStack.EMPTY);
                    SlotSender.sendSlot(user, 0, 45, ItemStack.EMPTY);
                },
                null,
                1
        );
    }
}