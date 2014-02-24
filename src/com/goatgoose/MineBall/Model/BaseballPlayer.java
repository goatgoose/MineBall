package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BaseballPlayer {

    private MineBall plugin;

    private Player player;

    private Team team;

    private GameState gameState;

    private Location catchBaseballHitboxCenter;

    private int catchBaseballHitboxRadius = 2;

    public enum Team {
        RED,
        BLUE,
        SPECTATOR
    }

    public enum GameState {
        FIELDING,
        HITTING,
        WAITING,
        SPECTATING
    }

    public BaseballPlayer(MineBall instance, Player player, Team team) {
        this.plugin = instance;
        this.player = player;
        this.team = team;
        this.gameState = GameState.WAITING;
    }

    public void baseballCatchEvent() {
        ItemStack bow = new ItemStack(Material.BOW);
        BaseballItem baseballItem = new BaseballItem(plugin, bow);
        player.getInventory().addItem(baseballItem.getBow());
    }

    public Player getPlayer() {
        return player;
    }

    public Team getTeam() {
        return team;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Location getCatchBaseballHitboxCenter() {
        return catchBaseballHitboxCenter;
    }

    public void setCatchBaseballHitboxCenter(Location location) {
        catchBaseballHitboxCenter = location;
    }

    public int getCatchBaseballHitboxRadius() {
        return catchBaseballHitboxRadius;
    }

    public int getFCoordinate() {
        double d = (player.getLocation().getYaw() * 4.0F / 360.0F) + 0.5D;
        int i = (int) d;
        return d < i ? i - 1 : i;
    }
}
