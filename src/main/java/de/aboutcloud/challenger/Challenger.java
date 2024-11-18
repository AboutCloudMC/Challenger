package de.aboutcloud.challenger;

import de.aboutcloud.challenger.data.database.mariadb.MariaDatabase;
import org.bukkit.plugin.java.JavaPlugin;

public final class Challenger extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        MariaDatabase db = new MariaDatabase("localhost", "challenger", "root", "admin");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
