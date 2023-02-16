package me.dabor.dievincussy.eventhandlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class PlayerInteractEventHandler implements Listener {
    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent evt) {
        evt.getPlayer().sendMessage(Objects.requireNonNull(evt.getClickedBlock()).getLocation().toString());
    }
}