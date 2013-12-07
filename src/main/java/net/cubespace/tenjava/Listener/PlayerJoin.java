package net.cubespace.tenjava.Listener;

import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:08
 */
public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(TenJavaPlugin.getMonsterManager().hasMonster(event.getPlayer())) {

        }
    }
}
