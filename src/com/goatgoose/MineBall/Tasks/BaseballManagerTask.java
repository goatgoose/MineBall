package com.goatgoose.mineball.Tasks;

import com.goatgoose.mineball.Model.Baseball;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class BaseballManagerTask implements Runnable {

    private JavaPlugin plugin;

    private int id = -1;

    private Baseball baseball;

    private Vector previousVelocity = new Vector();

    private Location currentLocation;

    public BaseballManagerTask(JavaPlugin plugin, Baseball baseball) {

        this.plugin = plugin;
        this.baseball = baseball;
        this.currentLocation = baseball.getArrow().getLocation();

        id = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this, 0, 1);

        if(id == -1) {
            plugin.getLogger().warning("Unable to schedule BaseballManagerTask");
        }
    }

    @Override
    public void run() {

        Location location = baseball.getArrow().getLocation();

        Vector velocity = baseball.getArrow().getVelocity();

        if(!velocity.equals(previousVelocity)) {
            currentLocation = location;
            previousVelocity = velocity;
        } else {
            stopTask();
        }

    }

    public boolean stopTask() {
        if(id != -1) {
            plugin.getServer().getScheduler().cancelTask(id);
            return true;
        }
        return false;
    }

}
