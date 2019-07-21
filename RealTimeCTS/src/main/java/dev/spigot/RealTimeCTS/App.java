package dev.spigot.RealTimeCTS;

// Bukkit Imports
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

// Java Imports
import java.io.File;


public class App extends JavaPlugin {

    String WebServiceURL;
    String WebServiceToken;

    @Override
    public void onEnable() {
        getLogger().info("Hello, SpigotMC!");

        UpdateAttr();
        EventListener.initialize(this);
                
        getServer().getPluginManager().registerEvents(new EventListener(), this);


        saveConfig();
    }
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }

    public void UpdateAttr(){
        WebServiceURL = getConfig().getString("WebServiceURL");
        WebServiceToken = getConfig().getString("WebServiceToken"); 
    }


    
    
}