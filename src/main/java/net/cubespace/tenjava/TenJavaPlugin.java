package net.cubespace.tenjava;

import net.cubespace.tenjava.Command.SetupArea;
import net.cubespace.tenjava.Manager.AreaManager;
import net.cubespace.tenjava.Manager.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 10:09
 */
public class TenJavaPlugin extends JavaPlugin {
    private static TenJavaPlugin instance;

    private static AreaManager areaManager;
    private static PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;

        //Init all Managers
        areaManager = new AreaManager();
        playerManager = new PlayerManager();

        //Setup Commands
        getCommand("setuparea").setExecutor(new SetupArea());

    }

    @Override
    public void onDisable() {

    }

    public static TenJavaPlugin getInstance() {
        return instance;
    }

    public static AreaManager getAreaManager() {
        return areaManager;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }
}
