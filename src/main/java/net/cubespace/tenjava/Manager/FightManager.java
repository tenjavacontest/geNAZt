package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

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
    }

    public boolean isInFight(Entity entity) {
        return inFight.contains(entity);
    }
}
