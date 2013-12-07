package net.cubespace.tenjava.Command;

import net.cubespace.tenjava.TenJavaPlugin;
import net.cubespace.tenjava.Util.CommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 17:33
 */
public class SetupArea implements CommandExecutor, Listener {
    private HashMap<Player, Vector> savedPoints = new HashMap<Player, Vector>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        //Check if commandSender is a Player or not
        if(CommandUtil.isPlayer(commandSender, "This command can only be used as Ingameplayer")) return true;
        Player player = (Player) commandSender;

        //Check if the Player has setup the first point
        if(!savedPoints.containsKey(player)) {
            savedPoints.put(player, player.getLocation().toVector());
            commandSender.sendMessage("[EF] Set point 1. Use /setuparea to complete the Area");
        } else {
            TenJavaPlugin.getAreaManager().createArea("Area-" + System.currentTimeMillis(), savedPoints.get(player), player.getLocation().toVector());
            savedPoints.remove(player);
            commandSender.sendMessage("[EF] Created Area. Please use /setareaname <name> to give the Area a name");
        }

        return true;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        //Be sure to delete the Player out of the HashMap if he logs off
        if(savedPoints.containsKey(event.getPlayer())) {
            savedPoints.remove(event.getPlayer());
        }
    }
}
