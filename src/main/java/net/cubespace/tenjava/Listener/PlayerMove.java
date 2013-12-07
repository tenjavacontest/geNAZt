package net.cubespace.tenjava.Listener;

import net.cubespace.tenjava.Database.Area;
import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:08
 */
public class PlayerMove implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Area foundArea = TenJavaPlugin.getAreaManager().getAreaForPlayer(event.getPlayer());

        if(foundArea != null) {
            TenJavaPlugin.getPlayerManager().setAreaForPlayer(foundArea, event.getPlayer());
        }
    }
}
