package net.cubespace.tenjava.Manager;

import net.cubespace.tenjava.Database.Area;
import net.cubespace.tenjava.TenJavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 07.12.13 17:02
 */
public class AreaManager {
    public ArrayList<Area> loadedAreas = new ArrayList<Area>();

    /**
     * Load all Areas on plugin init
     */
    public AreaManager() {
        //Check for Areas
        File databaseFolder = new File(TenJavaPlugin.getInstance().getDataFolder(), "database" + File.separator + "areas");
        if(!databaseFolder.exists()) {
            return;
        }

        //Check if Directory contains files
        File[] files = databaseFolder.listFiles();
        if(files == null || files.length == 0) {
            return;
        }

        //Load each Area
        for(File databaseFile : files) {
            Area loadedArea = Area.load(databaseFile);

            if(loadedArea != null)
                loadedAreas.add(loadedArea);
        }
    }

    /**
     * Create a new Area and save it as a File
     *
     * @param name The name of the Area
     * @param point1 First Point of the Area
     * @param point2 Second Point of the Area
     */
    public void createArea(String name, Vector point1, Vector point2) {
        //Check if there is an Area
        for(Area area : loadedAreas) {
            if(area.Point1X <= point1.getBlockX() &&
               area.Point1Y <= point1.getBlockY() &&
               area.Point1Z <= point1.getBlockZ() &&
               area.Point2X >= point2.getBlockX() &&
               area.Point2Y >= point2.getBlockY() &&
               area.Point2Z >= point2.getBlockZ()) {
                TenJavaPlugin.getInstance().getLogger().log(Level.WARNING, "There is an Area that conflicts with the new one");
                return;
            }
        }

        Area newArea = new Area();

        //Set point 1
        newArea.Point1X = point1.getBlockZ();
        newArea.Point1Y = point1.getBlockY();
        newArea.Point1Z = point1.getBlockZ();

        //Set point 2
        newArea.Point2X = point2.getBlockX();
        newArea.Point2Y = point2.getBlockY();
        newArea.Point2Z = point2.getBlockZ();

        Area.save(newArea, name);
    }

    private Area getVectorInArea(Vector checkVector) {
        for(Area area : loadedAreas) {
            if(area.Point1X <= checkVector.getBlockX() &&
               area.Point1Y <= checkVector.getBlockY() &&
               area.Point1Z <= checkVector.getBlockZ() &&
               area.Point2X >= checkVector.getBlockX() &&
               area.Point2Y >= checkVector.getBlockY() &&
               area.Point2Z >= checkVector.getBlockZ()) {
                return area;
            }
        }

        return null;
    }

    /**
     * Get the Area where the Player is standing in
     *
     * @param player
     * @return
     */
    public Area getAreaForPlayer(Player player) {
        return getVectorInArea(player.getLocation().toVector());
    }
}