package net.cubespace.tenjava.Database;

import net.cubespace.tenjava.TenJavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:53
 */
public class Monster {
    private static Yaml yaml = new Yaml();

    public Integer exp;
    public Integer level;
    public Integer health;
    public Integer damage;
    public String player;

    public static Monster load(File databaseFile) {
        try {
            return yaml.loadAs(new FileReader(databaseFile), Monster.class);

        } catch (FileNotFoundException e) {
            TenJavaPlugin.getInstance().getLogger().log(Level.SEVERE, null, e);
        }

        return null;
    }
}
