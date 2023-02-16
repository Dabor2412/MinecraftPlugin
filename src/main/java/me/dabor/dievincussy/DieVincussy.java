package me.dabor.dievincussy;

import me.dabor.dievincussy.commands.*;
import me.dabor.dievincussy.eventhandlers.LoginEvent;
import me.dabor.dievincussy.eventhandlers.PlayerInteractEventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DieVincussy extends JavaPlugin {
    private final Connection connection = DriverManager.getConnection("jdbc:mysql://138.3.243.163/minecraftdb", "root", "gis");

    public DieVincussy() throws SQLException {
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("hallowelt").setExecutor(new HalloWeltCommand());
        getCommand("changeblock").setExecutor(new ChangeBlockCommand());
        getCommand("greed").setExecutor(new GreedCommand(this.getServer()));
        getCommand("getmoney").setExecutor(new GetMoneyCommand(this.connection));
        getCommand("setmoney").setExecutor(new SetMoneyCommand(this.connection));
        getCommand("giveshoppingjournal").setExecutor(new GiveShoppingJournalCommand());
        getCommand("shop").setExecutor(new ShopCommand());

        getServer().getPluginManager().registerEvents(new LoginEvent(this.connection), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEventHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}