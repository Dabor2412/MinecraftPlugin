package me.dabor.dievincussy.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HalloWeltCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.setTotalExperience(69);

        ItemStack itemStack = new ItemStack(Material.RED_BANNER);
        player.getInventory().addItem(itemStack);

        Block block = player.getLocation().subtract(0, 1, 0).getBlock();
        block.setType(Material.DIAMOND_BLOCK);

        player.setWalkSpeed(0.2f);
    return false;
    }
}