package me.dabor.dievincussy.eventhandlers;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginEvent implements Listener {
    private Connection connection;

    @EventHandler
    public void onLogin(PlayerJoinEvent evt) throws SQLException, ClassNotFoundException {
        evt.getPlayer().sendMessage(ChatColor.AQUA + "Hallo " + evt.getPlayer().getName());
        executeSQL(evt.getPlayer());

        Component mainTitle = Component.text("Wilkommen zu ", TextColor.color(0x43A5AE)).append(Component.text("Wildlands", TextColor.color(0xFFFD55)));
        Component subTitle = Component.text("von Noel, Noah und Vincent", TextColor.color(0xB381));

        Title title = Title.title(mainTitle, subTitle);
        Audience audience = Audience.audience(evt.getPlayer());             //so viel verschwendete Zeit
        audience.showTitle(title);

        evt.getPlayer().playSound(evt.getPlayer().getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f);
    }

    private void executeSQL(Player player) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT count(*) AS spieleranzahl FROM minecraftdb.player WHERE player.username = '" + player.getName() + "'");

        if (resultSet.next() && resultSet.getInt("spieleranzahl") == 0) {
            Statement statement1 = this.connection.createStatement();
            statement1.execute("INSERT INTO player (username) values ('" + player.getName() + "')");
        }
        // wenn resultsetlänge == 1, dann nichts
    }

    public LoginEvent(Connection connection) {
        this.connection = connection;
    }
}