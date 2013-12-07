package net.cubespace.tenjava;

import net.cubespace.tenjava.Command.Fight;
import net.cubespace.tenjava.Listener.PlayerJoin;
import net.cubespace.tenjava.Listener.PlayerQuit;
import net.cubespace.tenjava.Manager.*;
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
    private static ConfigManager configManager;
    private static EntityManager entityManager;

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
        configManager = new ConfigManager();
        entityManager = new EntityManager();

        //Setup Commands
        getCommand("fight").setExecutor(new Fight());

        //Register Listener
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
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

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
