package com.goatgoose.mineball;

import com.goatgoose.mineball.Listeners.PlayerListener;
import com.goatgoose.mineball.Model.Baseball;
import com.goatgoose.mineball.Model.BaseballPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

public class MineBall extends JavaPlugin {

    private PlayerListener playerListener;

    private List<BaseballPlayer> baseballPlayers = new ArrayList<BaseballPlayer>();

    @EventHandler
    public void onEnable() {

        playerListener = new PlayerListener(this);

    }

    @EventHandler
    public void onDisable() {

    }

    public List<BaseballPlayer> getBaseballPlayers() {
        return baseballPlayers;
    }

    public void addBaseballPlayer(BaseballPlayer baseballPlayer) {
        baseballPlayers.add(baseballPlayer);
    }

    public BaseballPlayer getBaseballPlayer(Player player) {
        for(BaseballPlayer baseballPlayer : baseballPlayers) {
            if(baseballPlayer.getPlayer() == player) {
                return baseballPlayer;
            }
        }
        return null;
    }

}
