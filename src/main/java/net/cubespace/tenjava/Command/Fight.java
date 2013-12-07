package net.cubespace.tenjava.Command;

import net.cubespace.tenjava.TenJavaPlugin;
import net.cubespace.tenjava.Util.CommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:35
 */
public class Fight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        if(CommandUtil.isPlayer(commandSender, "You can't fight as Console")) return true;
        Player player = (Player) commandSender;

        //Check if the Player sees another player
        List<Entity> maybePlayers = player.getNearbyEntities(30D, 30D, 30D);
        for(Entity entity : maybePlayers) {
            if(entity instanceof Player) {
                Player battle = (Player) entity;
                TenJavaPlugin.getPlayerManager().sentInvitation(player, battle);
                return true;
            }
        }

        player.sendMessage("[EF] No player to battle against was found");
        return true;
    }
}
