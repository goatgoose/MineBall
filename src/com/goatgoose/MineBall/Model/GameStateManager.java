package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameStateManager {

    private MineBall plugin;

    private BaseballInningRoundManager.InningRound inningRound;

    public GameStateManager(MineBall plugin) {
        this.plugin = plugin;
    }

    public enum GameState {
        LOBBY,
        INGAME,
        ENDGAME
    }

    public void setGameState(GameState gameState) {
        plugin.setGameState(gameState);

        if(gameState == GameState.LOBBY) {
            onLOBBY();
        } else if(gameState == GameState.INGAME) {
            onINGAME();
        } else if (gameState == GameState.ENDGAME) {
            onENDGAME();
        }
    }

    public void onLOBBY() {
        setGameState(GameState.INGAME);
    }

    public void onINGAME() {

        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            if(plugin.getTeamBlue().size() > plugin.getTeamRed().size() || plugin.getTeamBlue().size() == plugin.getTeamRed().size()) {
                BaseballPlayer baseballPlayer = new BaseballPlayer(plugin, player, BaseballPlayer.Team.RED);
                plugin.addBaseballPlayer(baseballPlayer);
            } else if(plugin.getTeamRed().size() > plugin.getTeamBlue().size()) {
                BaseballPlayer baseballPlayer = new BaseballPlayer(plugin, player, BaseballPlayer.Team.BLUE);
                plugin.addBaseballPlayer(baseballPlayer);
            }
        }
    }

    public void onENDGAME() {

    }
}
