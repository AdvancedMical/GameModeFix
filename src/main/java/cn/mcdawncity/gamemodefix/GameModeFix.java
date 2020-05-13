package cn.mcdawncity.gamemodefix;

import cn.mcdawncity.gamemodefix.manager.ListenerManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import static cn.mcdawncity.gamemodefix.utils.Configuration.*;

public final class GameModeFix extends JavaPlugin {

    public static GameModeFix instance = null;

    public static GameModeFix getInstance() {
        return instance;
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        ENABLE = getConfig().getBoolean("Enable");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();
        reloadConfig();
        ListenerManager.register();
        getLogger().log(Level.INFO, "插件已启动,作者Mical");
        if (!ENABLE){
            getLogger().log(Level.SEVERE, "插件未设置开启,自动关闭...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getScheduler().cancelTasks(this);
        getLogger().log(Level.INFO, "插件已卸载");
    }
}
