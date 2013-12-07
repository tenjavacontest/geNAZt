package net.cubespace.tenjava.Util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 17:45
 */
public class CommandUtil {
    public static boolean isPlayer(CommandSender commandSender, String sendIfNot) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(sendIfNot);
            return true;
        }

        return false;
    }
}
