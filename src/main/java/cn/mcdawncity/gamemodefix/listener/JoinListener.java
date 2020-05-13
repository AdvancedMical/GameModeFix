package cn.mcdawncity.gamemodefix.listener;

import cn.mcdawncity.gamemodefix.GameModeFix;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        event.getPlayer().setGameMode(GameMode.valueOf(GameModeFix.getInstance().getConfig().getString("data." + event.getPlayer().getUniqueId().toString())));
    }
}
