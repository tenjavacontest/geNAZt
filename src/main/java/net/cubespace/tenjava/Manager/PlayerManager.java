package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.Database.Area;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:10
 */
public class PlayerManager {
    private HashMap<Player, Area> playerInAreas = new HashMap<Player, Area>();

    public void setAreaForPlayer(Area foundArea, Player player) {
        playerInAreas.put(player, foundArea);
    }
}
