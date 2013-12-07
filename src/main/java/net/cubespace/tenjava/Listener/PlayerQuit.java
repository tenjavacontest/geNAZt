package net.cubespace.tenjava.Listener;

import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:17
 */
public class PlayerQuit implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if(TenJavaPlugin.getPlayerManager().hasInvitation(event.getPlayer())) {
            TenJavaPlugin.getPlayerManager().cancelInvitation(event.getPlayer());
        }

        TenJavaPlugin.getEntityManager().removeEntity(event.getPlayer());
        TenJavaPlugin.getFightManager().cancelFight(event.getPlayer());
    }
}
