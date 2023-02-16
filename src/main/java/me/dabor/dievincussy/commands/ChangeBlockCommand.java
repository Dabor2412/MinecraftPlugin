package me.dabor.dievincussy.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChangeBlockCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (int i = 0; i < 100; i++) {
                Block targetBlock = player.getTargetBlock(420);
                assert targetBlock != null;
                targetBlock.setType(Material.AIR);
            }
        }
        return false;
    }
}