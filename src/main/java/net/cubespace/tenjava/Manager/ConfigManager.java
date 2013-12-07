package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.TenJavaPlugin;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 19:04
 */
public class ConfigManager {
    private ArrayList<LinkedHashMap> evolutions = new ArrayList<LinkedHashMap>();

    public ConfigManager() {
        evolutions = (ArrayList<LinkedHashMap>) TenJavaPlugin.getInstance().getConfig().getList("Monsters");
    }

    public LinkedHashMap getNext(int nextEvolution) {
        if(evolutions.size() > nextEvolution) {
            return evolutions.get(nextEvolution+1);
        }

        return null;
    }

    public LinkedHashMap getExact(int evolution) {
        if(evolutions.size() >= evolution) {
            return evolutions.get(evolution);
        }

        return null;
    }
}
