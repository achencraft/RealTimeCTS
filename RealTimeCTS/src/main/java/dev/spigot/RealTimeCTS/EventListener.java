package dev.spigot.RealTimeCTS;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.block.Sign;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import dev.spigot.RealTimeCTS.App;
import dev.spigot.RealTimeCTS.json;

import com.google.gson.*;

public class EventListener implements Listener
{
    private static App plugin;
    public static void initialize(App instance) {
        plugin = instance;
    }
    
    @EventHandler
     public void onSignChange(SignChangeEvent event) throws Exception
     {
        String IDSAE = "";
        if(event.getLine(0).equalsIgnoreCase("[CTS]")){
            IDSAE = event.getLine(1);
            event.setLine(0, ChatColor.BLUE + "Temps d'attente");
            if(event.getLine(1).isEmpty()){
                Bukkit.broadcastMessage("La seconde ligne doit contenir l'identifiant de l'arrêt CTS");
            } else {
                Bukkit.broadcastMessage(IDSAE);
                Bukkit.broadcastMessage(getStopName(event.getLine(1)));
            }
            
        }


     }


     public String getJson(String IDSAE) throws Exception{
        String URL = plugin.getConfig().getString("WebServiceURL");
        final String token = plugin.getConfig().getString("WebServiceToken");
        URL = URL + IDSAE;

        HttpRequest req = new HttpRequest();
        String chaine = req.readUrl(URL,token);

        return chaine;
     }

     public String getStopName(String IDSAE) throws Exception{

        String chaine = getJson(IDSAE);

        Gson gson = new Gson();     
        json info = gson.fromJson(chaine, json.class);        
        return info.ServiceDelivery.StopMonitoringDelivery[0].MonitoredStopVisit[0].MonitoredVehicleJourney.MonitoredCall.StopPointName;
     }




     public String[] getWaitingTime(String IDSAE, int nbr){
        String output[] = new String[3]; 

        return output;
     }

}