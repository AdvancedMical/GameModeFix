package cn.mcdawncity.gamemodefix.listener;

import cn.mcdawncity.gamemodefix.GameModeFix;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        if (GameModeFix.getInstance().getConfig().getString("data." + event.getPlayer().getUniqueId()) == null){
            GameModeFix.getInstance().getConfig().set("data." + event.getPlayer().getUniqueId(), event.getPlayer().getGameMode().toString());
        }
        event.getPlayer().setGameMode(GameMode.valueOf(GameModeFix.getInstance().getConfig().getString("data." + event.getPlayer().getUniqueId())));
    }
}
