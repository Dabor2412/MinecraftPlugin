package me.dabor.dievincussy.utility;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoneyManager {
    private final Connection connection;

    public int getMoney(CommandSender sender) {
        int money = -1;

        Player player = (Player) sender;

        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            sender.sendMessage(1 + e.toString());
        }

        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery("SELECT player.money FROM minecraftdb.player WHERE player.username = '" + player.getName() + "'");
        } catch (SQLException e) {
            sender.sendMessage(2 + e.toString());
        }

        try {
            resultSet.next();
            money = resultSet.getInt("money");
        } catch (Exception e) {
            sender.sendMessage(3 + e.toString());
        }

        return money;
    }

    public MoneyManager(Connection i) {
        this.connection = i;
    }
}
