package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.Database.Monster;
import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:52
 */
public class MonsterManager {
    private HashMap<String, Monster> playerHasMonster = new HashMap<String, Monster>();

    public MonsterManager() {
        //Check for Monsters
        File databaseFolder = new File(TenJavaPlugin.getInstance().getDataFolder(), "database" + File.separator + "monsters");
        if(!databaseFolder.exists()) {
            return;
        }

        //Check if Directory contains files
        File[] files = databaseFolder.listFiles();
        if(files == null || files.length == 0) {
            return;
        }

        //Load each Monster
        for(File databaseFile : files) {
            Monster loadedMonster = Monster.load(databaseFile);

            if(loadedMonster != null)
                playerHasMonster.put(loadedMonster.player, loadedMonster);
        }
    }

    public boolean hasMonster(Player player) {
        return playerHasMonster.containsKey(player.getName());
    }

    public void createNewMonster(Player player) {

    }
}
