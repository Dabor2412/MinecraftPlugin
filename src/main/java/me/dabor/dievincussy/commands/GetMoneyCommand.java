package me.dabor.dievincussy.commands;

import me.dabor.dievincussy.utility.MoneyManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class GetMoneyCommand implements CommandExecutor {
    private final Connection connection;

    public GetMoneyCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        MoneyManager moneyManager = new MoneyManager(this.connection);
        sender.sendMessage("Du besitzt " + ChatColor.GREEN + moneyManager.getMoney(sender) + ChatColor.WHITE + " Geld.");

        return false;
    }
}
