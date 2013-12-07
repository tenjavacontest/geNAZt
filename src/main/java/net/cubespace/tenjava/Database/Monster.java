package net.cubespace.tenjava.Database;

import net.cubespace.tenjava.TenJavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.logging.Level;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 18:53
 */
public class Monster {
    private static Yaml yaml = new Yaml();

    public String name;
    public Integer exp;
    public Integer level;
    public Double health;
    public Double damage;
    public Integer evolution;
    public String player;
    public Integer entityId;

    public static Monster load(File databaseFile) {
        try {
            return yaml.loadAs(new FileReader(databaseFile), Monster.class);

        } catch (FileNotFoundException e) {
            TenJavaPlugin.getInstance().getLogger().log(Level.SEVERE, null, e);
        }

        return null;
    }

    public boolean save() {
        try {
            File monsterFile = new File(TenJavaPlugin.getInstance().getDataFolder(), "database" + File.separator + "monsters" + File.separator +  this.player + ".yml");

            //Check if file exists
            if (!monsterFile.exists()) {
                if ((!monsterFile.getParentFile().exists() && !monsterFile.getParentFile().mkdirs()) || !monsterFile.createNewFile()) {
                    return false;
                }
            }

            //Create a new FileWriter and take the Dump from YAML and write it into the File
            FileWriter fileWriter = new FileWriter(monsterFile);
            String yamlOutput = yaml.dump(this);

            fileWriter.write(yamlOutput);
            fileWriter.close();

            return true;
        } catch (IOException e) {
            TenJavaPlugin.getInstance().getLogger().log(Level.SEVERE, null, e);
        }

        return false;
    }
}
