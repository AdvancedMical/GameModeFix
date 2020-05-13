package cn.mcdawncity.gamemodefix.listener;

import cn.mcdawncity.gamemodefix.GameModeFix;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void quit(PlayerQuitEvent event){
        GameModeFix.getInstance().getConfig().set("data." + event.getPlayer().getUniqueId().toString(), event.getPlayer().getGameMode().toString());
    }
}
