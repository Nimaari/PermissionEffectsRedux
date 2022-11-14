package tk.nimari;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;

public class Command implements CommandExecutor {

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            reloadPermissionEffects();
            player.sendMessage("§8[§bPermissionEffects§8] §aSuccessfully reloaded.");

        } else {
            reloadPermissionEffects();
            sender.sendMessage("Successfully reloaded.");
        }

        return true;
    }

    private void reloadPermissionEffects() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (PotionEffect potionEffect : player.getActivePotionEffects())
                player.removePotionEffect(potionEffect.getType());

            new EffectGiver(player);
        }
    }
}
