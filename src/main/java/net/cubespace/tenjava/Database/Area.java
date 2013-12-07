package net.cubespace.tenjava.Database;

import net.cubespace.tenjava.TenJavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.logging.Level;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 17:02
 */
public class Area {
    //Create a YAML Reader/Writer
    private static Yaml yaml = new Yaml();

    //Complete Point1
    public Integer Point1X = 0;
    public Integer Point1Y = 0;
    public Integer Point1Z = 0;

    //Complete Point2
    public Integer Point2X = 0;
    public Integer Point2Y = 0;
    public Integer Point2Z = 0;

    //Name of the Area
    public String AreaName = "";

    /**
     * Load a new Area Database Entry based on the name given
     *
     * @param name The name of the Area which should be loaded
     */
    public static Area load(String name) {
        try {
            return yaml.loadAs(new FileReader(getFile(name)), Area.class);

        } catch (FileNotFoundException e) {
            TenJavaPlugin.getInstance().getLogger().log(Level.SEVERE, null, e);
        }

        return null;
    }

    /**
     * Load a new Area Database Entry based on the file given
     *
     * @param file The File to load
     */
    public static Area load(File file) {
        try {
            return yaml.loadAs(new FileReader(file), Area.class);

        } catch (FileNotFoundException e) {
            TenJavaPlugin.getInstance().getLogger().log(Level.SEVERE, null, e);
        }

        return null;
    }

    /**
     * Saves the Area into a YAML File
     *
     * @param area The Area which should be saved
     * @param name The name of the Area
     * @return If the File could be saved true otherwise false
     */
    public static boolean save(Area area, String name) {
        try {
            File areaFile = getFile(name);

            //Check if file exists
            if(!areaFile.exists()) {
                if((!areaFile.getParentFile().exists() && !areaFile.getParentFile().mkdirs()) || !areaFile.createNewFile()) {
                    return false;
                }
            }

            //Create a new FileWriter and take the Dump from YAML and write it into the File
            FileWriter fileWriter = new FileWriter(areaFile);
            String yamlOutput = yaml.dump(area);

            fileWriter.write(yamlOutput);
            fileWriter.close();

            return true;
        } catch (IOException e) {
            TenJavaPlugin.getInstance().getLogger().log(Level.SEVERE, null, e);
        }

        return false;
    }

    /**
     * Gets the correct File for this Areaname
     *
     * @param areaName
     * @return
     */
    private static File getFile(String areaName) {
        return new File(TenJavaPlugin.getInstance().getDataFolder(), "database" + File.separator + "areas" + File.separator + areaName +".yml");
    }
}
