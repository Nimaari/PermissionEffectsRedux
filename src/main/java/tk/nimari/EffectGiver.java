package tk.nimari;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectGiver {

    @SuppressWarnings("deprecation")
    public EffectGiver(Player player) {

        // TODO: Make this better somehow?

        if (!player.hasPermission("pe.bypass"))
            for (PotionEffectType possibleEffect : PotionEffectType.values())
                if (player.hasPermission("pe." + possibleEffect.getName().toLowerCase()))
                    player.addPotionEffect(new PotionEffect(possibleEffect, Integer.MAX_VALUE, 0, false, false));
                else
                    for (int i = 0; i < 256; i++)
                        if (player.hasPermission("pe." + possibleEffect.getName().toLowerCase() + "." + i)) {
                            player.addPotionEffect(new PotionEffect(possibleEffect, Integer.MAX_VALUE, i, false, false));
                            break;
                        }


    }
}
