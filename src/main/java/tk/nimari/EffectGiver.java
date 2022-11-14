package tk.nimari;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectGiver {

    public EffectGiver(Player player) {

        // TODO: Make this better somehow?

        if (!player.hasPermission("pe.bypass"))
            for (PotionEffectType possibleEffect : PotionEffectType.values())
                if (player.hasPermission("pe." + possibleEffect.toString().toLowerCase()))
                    for (int i = 1; i < 20; i++) {
                        if (player.hasPermission("pe." + possibleEffect.toString().toLowerCase() + "." + i)) {
                            player.addPotionEffect(new PotionEffect(possibleEffect, Integer.MAX_VALUE, i, false, false));
                            break;
                        }
                        player.addPotionEffect(new PotionEffect(possibleEffect, Integer.MAX_VALUE, 0, false, false));
                    }
    }
}
