package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:50
 */
public class FightManager {
    private HashMap<Player, Player> currentFights = new HashMap<Player, Player>();
    private ArrayList<Entity> inFight = new ArrayList<Entity>();

    public void startFight(Player starter, Player enemy) {
        inFight.add(TenJavaPlugin.getEntityManager().getEntity(starter));
        inFight.add(TenJavaPlugin.getEntityManager().getEntity(enemy));

        currentFights.put(starter, enemy);
    }

    public boolean isInFight(Entity entity) {
        return inFight.contains(entity);
    }

    public void cancelFight(Player player) {
        //Check if Player is sender of a invitation
        if(currentFights.containsValue(player)) {
            for(Map.Entry<Player, Player> mapEntry : currentFights.entrySet()) {
                if(mapEntry.getValue().equals(player)) {
                    mapEntry.getKey().sendMessage("[EF] The enemy escaped !");

                    inFight.remove(TenJavaPlugin.getEntityManager().getEntity(mapEntry.getKey()));
                    inFight.remove(TenJavaPlugin.getEntityManager().getEntity(mapEntry.getValue()));
                    currentFights.remove(mapEntry.getKey());

                    break;
                }
            }
        }

        //Check if the Player is receiver of the invitation
        if(currentFights.containsKey(player)) {
            currentFights.get(player).sendMessage("[EF] TThe enemy escaped !");

            inFight.remove(TenJavaPlugin.getEntityManager().getEntity(player));
            inFight.remove(TenJavaPlugin.getEntityManager().getEntity(currentFights.get(player)));

            currentFights.remove(player);
        }
    }
}
