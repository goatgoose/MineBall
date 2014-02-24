package com.goatgoose.mineball.Tasks;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Model.Baseball;
import com.goatgoose.mineball.Model.BaseballPlayer;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class BaseballManagerTask implements Runnable {

    private MineBall plugin;

    private int id = -1;

    private Baseball baseball;

    private BaseballPlayer owner;

    private Vector previousVelocity = new Vector();

    private Location currentLocation;

    public BaseballManagerTask(MineBall instance, Baseball baseball, BaseballPlayer owner) {
        this.plugin = instance;
        this.baseball = baseball;
        this.owner = owner;
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

            for(BaseballPlayer baseballPlayer : plugin.getBaseballPlayers()) {
                if(!baseballPlayer.equals(owner)) {
                    if(currentLocation.distance(baseballPlayer.getCatchBaseballHitboxCenter()) < baseballPlayer.getCatchBaseballHitboxRadius()) {
                        baseballPlayer.baseballCatchEvent();
                        stopTask();
                    }
                }
            }
        } else {
            // TODO create new BaseballItem at this location
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

    public Location getCurrentLocation() {
        return currentLocation;
    }

}
