package com.goatgoose.mineball.Listeners;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Model.Baseball;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class PlayerListener implements Listener {

    private MineBall plugin;

    public PlayerListener(MineBall instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {

        Player shooter;

        if(event.getEntity() instanceof Player) {
            shooter = (Player)event.getEntity();

            Baseball baseball = new Baseball((Arrow)event.getProjectile());

        }
    }

}
