package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.Database.Monster;
import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 19:31
 */
public class EntityManager {
    private final HashMap<Player, Entity> playerEntityHashMap = new HashMap<Player, Entity>();

    public EntityManager() {
        Bukkit.getScheduler().runTaskTimer(TenJavaPlugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(Map.Entry<Player, Entity> playerEntityEntry : playerEntityHashMap.entrySet()) {
                    if(!TenJavaPlugin.getFightManager().isInFight(playerEntityEntry.getValue())) {
                        playerEntityEntry.getValue().teleport(playerEntityEntry.getKey());
                    }
                }
            }
        }, 40, 5);
    }

    public void spawnMonster(Player player) {
        Monster monster = TenJavaPlugin.getMonsterManager().getMonster(player);
        LinkedHashMap configurationSection = TenJavaPlugin.getConfigManager().getExact(monster.evolution);

        String entity = (String) configurationSection.get("entity");
        if(entity.equals("Chicken")) {
            final Entity chicken = player.getWorld().spawnEntity(player.getLocation().add(new Vector(0,1,0)), EntityType.CHICKEN);
            monster.entityId = chicken.getEntityId();

            playerEntityHashMap.put(player, chicken);
            Bukkit.getScheduler().runTaskLater(TenJavaPlugin.getInstance(), new Runnable() {
                @Override
                public void run() {
                    chicken.playEffect(EntityEffect.WOLF_HEARTS);
                }
            }, 5*20);
        }
    }

    public Entity getEntity(Player player) {
        return playerEntityHashMap.get(player);
    }
}
