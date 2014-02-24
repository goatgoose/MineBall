package com.goatgoose.mineball;

import com.goatgoose.mineball.Listeners.PlayerListener;
import com.goatgoose.mineball.Model.Baseball;
import com.goatgoose.mineball.Model.BaseballPlayer;
import com.goatgoose.mineball.Model.GameplayBlocks;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

public class MineBall extends JavaPlugin {

    private PlayerListener playerListener;

    private List<BaseballPlayer> baseballPlayers = new ArrayList<BaseballPlayer>();

    public GameState gameState;

    public enum GameState {
        LOBBY,
        INGAME,
        ENDGAME
    }

    @EventHandler
    public void onEnable() {

        playerListener = new PlayerListener(this);

        gameState = GameState.LOBBY;

    }

    @EventHandler
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if(command.getName().equalsIgnoreCase("mb")) {

            if(args.length == 0){
                // TODO show plugin help
                getLogger().info("Plugin help coming soon!");

                return true;
            }

            // ************************************
            // TODO make this permanent per map for minigame server
            else if(args[0].equalsIgnoreCase("firstbase")) {
                GameplayBlocks.firstBase = Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlock();
                return true;
            }
            else if(args[0].equalsIgnoreCase("secondbase")) {
                GameplayBlocks.secondBase = Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlock();
                return true;
            }
            else if(args[0].equalsIgnoreCase("thirdbase")) {
                GameplayBlocks.thirdBase = Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlock();
                return true;
            }
            else if(args[0].equalsIgnoreCase("homeplate")) {
                GameplayBlocks.homePlate = Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlock();
                return true;
            }
            else if(args[0].equalsIgnoreCase("pitchersmound")) {
                if(!GameplayBlocks.pitchersMound.contains(Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlock())) {
                    GameplayBlocks.pitchersMound.add(Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlock());
                }
                return true;
            }
            // ************************************

            return false;
        }

        return false;
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
