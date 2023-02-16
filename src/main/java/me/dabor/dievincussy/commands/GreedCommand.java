package me.dabor.dievincussy.commands;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GreedCommand implements CommandExecutor {
    private Server server;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            Player player = (Player) sender;
            World world = this.server.getWorlds().get(0);
            List<Player> players = world.getPlayers();
            for (Player i : players) {
                i.sendMessage(player.getName() + " grüßt " + args[0]);
            }
        } else sender.sendMessage("Die Syntax ist nicht korrekt");
        return false;
    }

    public GreedCommand(Server server) {
        this.server = server;
    }
}
