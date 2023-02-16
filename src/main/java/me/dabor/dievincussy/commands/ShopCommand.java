package me.dabor.dievincussy.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Inventory inventory = Bukkit.createInventory(null, 54, Component.text("Shop"));
        inventory.setItem(0 , new ItemStack(Material.BOOK, 1));
        Player player = (Player) sender;
        player.openInventory(inventory);

        return false;
    }
}
