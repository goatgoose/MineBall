package com.goatgoose.mineball;

import com.goatgoose.mineball.Listeners.PlayerListener;
import com.goatgoose.mineball.Model.Baseball;
import com.goatgoose.mineball.Tasks.BaseballManagerTask;
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

    private static PlayerListener playerListener;

    public List<Player> fieldingPlayers = new ArrayList<Player>();

    public List<Player> battingPlayers = new ArrayList<Player>();

    @EventHandler
    public void onEnable() {

        playerListener = new PlayerListener(this);

    }

    @EventHandler
    public void onDisable() {

    }

}
