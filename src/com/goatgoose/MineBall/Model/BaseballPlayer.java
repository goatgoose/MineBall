package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BaseballPlayer {

    private MineBall plugin;

    private Player player;

    private Team team;

    private State teamState;

    private Location catchBaseballHitboxCenter;

    private int catchBaseballHitboxRadius = 2;

    public enum Team {
        RED,
        BLUE,
        WAITING,
        SPECTATOR
    }

    public enum State {
        FIELDING,
        HITTING,
        WAITING,
        SPECTATING
    }

    public BaseballPlayer(MineBall instance, Player player, Team team) {
        this.plugin = instance;
        this.player = player;
        this.team = team;
        this.teamState = State.WAITING;
        plugin.addBaseballPlayer(this);
    }

    public void baseballCatchEvent() {
        ItemStack bow = new ItemStack(Material.BOW);
        BaseballItem baseballItem = new BaseballItem(plugin, bow);
        player.getInventory().addItem(baseballItem.getBow());
    }

    public int getFCoordinate() {
        double d = (player.getLocation().getYaw() * 4.0F / 360.0F) + 0.5D;
        int i = (int) d;
        return d < i ? i - 1 : i;
    }

    public void addToGame() {
        if(plugin.getTeamBlue().size() > plugin.getTeamRed().size() || plugin.getTeamBlue().size() == plugin.getTeamRed().size()) {
            setTeam(Team.RED);
        } else if(plugin.getTeamRed().size() > plugin.getTeamBlue().size()) {
            setTeam(Team.BLUE);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public State getState() {
        return teamState;
    }

    public void setState(State teamState) {
        this.teamState = teamState;
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
}
