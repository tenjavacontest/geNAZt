package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:10
 */
public class PlayerManager {
    private HashMap<Player, Player> sentInvitation = new HashMap<Player, Player>();

    public void sentInvitation(Player sender, Player receiver) {
        if(sentInvitation.containsValue(sender)) {
            sender.sendMessage("[EF] You can only battle one Person at once");
            return;
        }

        receiver.sendMessage("[EF] " + sender.getDisplayName() + " wants to battle you. /fight accept to fight, /fight cancel to cancel the invitation");
        sentInvitation.put(receiver, sender);
    }

    public boolean hasInvitation(Player player) {
        return sentInvitation.containsKey(player);
    }

    public void cancelInvitation(Player player) {
        //Check if Player is sender of a invitation
        if(sentInvitation.containsValue(player)) {
            for(Map.Entry<Player, Player> mapEntry : sentInvitation.entrySet()) {
                if(mapEntry.getValue().equals(player)) {
                    mapEntry.getValue().sendMessage("[EF] You canceld the invitation");
                    mapEntry.getKey().sendMessage("[EF] The sender of the invitation has canceld the Fight");

                    sentInvitation.remove(mapEntry.getKey());

                    break;
                }
            }
        }

        //Check if the Player is receiver of the invitation
        if(sentInvitation.containsKey(player)) {
            sentInvitation.get(player).sendMessage("[EF] The challenge has not been accepted");
            player.sendMessage("[EF] You have canceld the Fight");
            sentInvitation.remove(player);
        }
    }

    public void acceptInvitation(Player player) {
        //Check if there is a invitation
        if(sentInvitation.containsKey(player)) {
            sentInvitation.get(player).sendMessage("[EF] The fight has started");
            player.sendMessage("[EF] The fight has started");

            TenJavaPlugin.getFightManager().startFight(sentInvitation.get(player), player);
            sentInvitation.remove(player);
        }
    }
}
