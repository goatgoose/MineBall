package com.goatgoose.mineball;

import com.goatgoose.mineball.Listeners.PlayerListener;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class MineBall extends JavaPlugin {

    private static PlayerListener playerListener;

    @EventHandler
    public void onEnable() {

        playerListener = new PlayerListener(this);

    }

    @EventHandler
    public void onDisable() {

    }

}
