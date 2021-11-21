package megaaa.worldreload;

import megaaa.worldreload.commands.ReloadMap;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public final class WorldReload extends JavaPlugin {

    private static File mapFolder;

    @Override
    public void onEnable() {
        mapFolder = new File(getDataFolder(), "mapBackup");
        getCommand("reloadmap").setExecutor(new ReloadMap());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        if (!mapFolder.exists()) {
            if (!mapFolder.mkdir()) {
                Bukkit.getConsoleSender().sendMessage("WorldReload >> " + "Could not create mapsBackup folder! Check permissions!");
            }
        }
        try {
            FileUtils.copyDirectory(mapFolder, new File(".", "world1"));
        } catch (IOException | NullPointerException e) {
            Bukkit.getConsoleSender().sendMessage("World §b" + "backup" + " §7couldn't be restored." + e);
        }
        Bukkit.getConsoleSender().sendMessage("§aI'm alive !");
    }

    @Override
    public void onDisable() {
    }

}
