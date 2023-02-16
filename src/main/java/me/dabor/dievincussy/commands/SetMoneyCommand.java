package me.dabor.dievincussy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetMoneyCommand implements CommandExecutor {
    private final Connection connection;

    public SetMoneyCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            Statement statement = connection.createStatement();
            Player player = (Player) sender;
            statement.execute("UPDATE minecraftdb.player SET player.money = '" + args[0] + "' WHERE player.username = '" + player.getName() + "'");
        } catch (SQLException e) {
            sender.sendMessage(e.toString());
        }

        return false;
    }
}
