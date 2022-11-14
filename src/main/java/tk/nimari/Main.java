package tk.nimari;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        long currentTime = System.currentTimeMillis();

        instance = this;

        new Metrics(this, 16869);

        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getCommand("permissioneffects").setExecutor(new Command());

        getLogger().log(Level.INFO, "Successful startup! Took " + (System.currentTimeMillis() - currentTime) + "ms.");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Leaving so soon? Have a nice day!");
    }
}
