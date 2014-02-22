package com.goatgoose.mineball.Listeners;

import com.goatgoose.mineball.MineBall;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.goatgoose.mineball.Events.*;

public class BaseballMoveEventListener implements Listener {

    private MineBall plugin;

    public BaseballMoveEventListener(MineBall instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBaseBallMove(BaseballMoveEvent event) {

    }

}
