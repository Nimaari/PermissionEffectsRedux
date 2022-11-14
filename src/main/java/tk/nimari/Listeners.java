package tk.nimari;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Listeners implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e) {
        new EffectGiver(e.getPlayer());
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                new EffectGiver(e.getPlayer());
            }
        }.runTaskLater(Main.instance, 5L);
    }

    @EventHandler
    public void bucket(PlayerItemConsumeEvent e) {
        if (e.getItem().getType() == Material.MILK_BUCKET)
            new BukkitRunnable() {
                @Override
                public void run() {
                    new EffectGiver(e.getPlayer());
                }
            }.runTaskLater(Main.instance, 5L);
    }
}
