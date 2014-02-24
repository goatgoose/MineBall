package com.goatgoose.mineball.Listeners;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Model.Baseball;
import com.goatgoose.mineball.Model.BaseballPlayer;
import com.goatgoose.mineball.Tasks.BaseballManagerTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class PlayerListener implements Listener {

    private MineBall plugin;

    public PlayerListener(MineBall instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {

        if(event.getEntity() instanceof Player) {
            BaseballPlayer shooter = plugin.getBaseballPlayer((Player)event.getEntity());
            Baseball baseball = new Baseball(plugin, (Arrow)event.getProjectile(), shooter);

            if(shooter == null) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        BaseballPlayer baseballPlayer = plugin.getBaseballPlayer(event.getPlayer());

        Block block = baseballPlayer.getPlayer().getLocation().getBlock();

        if(baseballPlayer.getGameState() == BaseballPlayer.GameState.FIELDING) {
            Location playerCenter = baseballPlayer.getPlayer().getLocation();
            playerCenter.setY(baseballPlayer.getPlayer().getLocation().getY() + 1);
            baseballPlayer.setCatchBaseballHitboxCenter(playerCenter);
        }

        else if(baseballPlayer.getGameState() == BaseballPlayer.GameState.HITTING) {
            // TODO check if on bases and keep from moving if hitting
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        int playersOnRedTeam = 0;
        int playersOnBlueTeam = 0;

        for(BaseballPlayer baseballPlayer : plugin.getBaseballPlayers()) {
            if(baseballPlayer.getTeam() == BaseballPlayer.Team.RED) {
                playersOnRedTeam = playersOnRedTeam + 1;
            } else if(baseballPlayer.getTeam() == BaseballPlayer.Team.BLUE) {
                playersOnBlueTeam = playersOnBlueTeam + 1;
            }
        }

        if(playersOnBlueTeam > playersOnRedTeam || playersOnBlueTeam == playersOnRedTeam) {
            BaseballPlayer baseballPlayer = new BaseballPlayer(plugin, player, BaseballPlayer.Team.RED);

            // TEMP DEV SETTINGS
            baseballPlayer.setGameState(BaseballPlayer.GameState.FIELDING);

            plugin.addBaseballPlayer(baseballPlayer);
        } else if(playersOnRedTeam > playersOnBlueTeam) {
            BaseballPlayer baseballPlayer = new BaseballPlayer(plugin, player, BaseballPlayer.Team.BLUE);

            // TEMP DEV SETTINGS
            baseballPlayer.setGameState(BaseballPlayer.GameState.FIELDING);

            plugin.addBaseballPlayer(baseballPlayer);
        }

    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        event.setCancelled(true);
    }

}
