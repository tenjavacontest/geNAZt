package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 19:04
 */
public class ConfigManager {
    private ArrayList<ConfigurationSection> evolutions = new ArrayList<ConfigurationSection>();

    public ConfigManager() {
        List<ConfigurationSection> configurationSectionList = (List<ConfigurationSection>) TenJavaPlugin.getInstance().getConfig().getList("Monsters");
        System.out.println(configurationSectionList.size());
    }
}
