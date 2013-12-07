package net.cubespace.tenjava;

import net.cubespace.tenjava.Command.Fight;
import net.cubespace.tenjava.Manager.ConfigManager;
import net.cubespace.tenjava.Manager.FightManager;
import net.cubespace.tenjava.Manager.MonsterManager;
import net.cubespace.tenjava.Manager.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 10:09
 */
public class TenJavaPlugin extends JavaPlugin {
    private static TenJavaPlugin instance;

    private static PlayerManager playerManager;
    private static FightManager fightManager;
    private static MonsterManager monsterManager;

    @Override
    public void onEnable() {
        instance = this;

        //Load the config
        getConfig().options().copyDefaults(true);
        saveConfig();

        //Init all Managers
        playerManager = new PlayerManager();
        fightManager = new FightManager();
        monsterManager = new MonsterManager();
        new ConfigManager();

        //Setup Commands
        getCommand("fight").setExecutor(new Fight());
    }

    @Override
    public void onDisable() {

    }

    public static TenJavaPlugin getInstance() {
        return instance;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static FightManager getFightManager() {
        return fightManager;
    }

    public static MonsterManager getMonsterManager() {
        return monsterManager;
    }
}
