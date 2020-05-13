package cn.mcdawncity.gamemodefix.manager;


import cn.mcdawncity.gamemodefix.GameModeFix;
import cn.mcdawncity.gamemodefix.listener.JoinListener;
import cn.mcdawncity.gamemodefix.listener.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenerManager {

    private static void register(Listener listener){
        Bukkit.getPluginManager().registerEvents(listener, GameModeFix.getInstance());
    }

    public static void register(){
        register(new JoinListener());
        register(new QuitListener());
    }

}