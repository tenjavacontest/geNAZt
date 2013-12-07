package net.cubespace.tenjava.Command;

import net.cubespace.tenjava.Util.CommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:35
 */
public class Fight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        if(!CommandUtil.isPlayer(commandSender, "You can't fight as Console")) return true;

        return false;
    }
}
