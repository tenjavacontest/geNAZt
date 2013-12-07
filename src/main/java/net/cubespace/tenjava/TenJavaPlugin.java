package net.cubespace.tenjava;

import net.cubespace.tenjava.Manager.AreaManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 10:09
 */
public class TenJavaPlugin extends JavaPlugin {
    private static TenJavaPlugin instance;

    private static AreaManager areaManager;

    @Override
    public void onEnable() {
        instance = this;

        //Init all Managers
        areaManager = new AreaManager(this);
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
}
