package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;

public class BaseballInningRoundManager {

    private MineBall plugin;

    private BaseballInning baseballInning;

    public enum InningRound {
        ROUND1,
        ROUND2
    }

    public BaseballInningRoundManager(MineBall plugin, BaseballInning baseballInning) {
        this.plugin = plugin;
        this.baseballInning = baseballInning;
    }

    public void onRoundChange() {
        for(BaseballPlayer baseballPlayer : plugin.getWaiting()) {
            baseballPlayer.addToGame();
        }
    }

    public void onROUND1() {

    }

    public void onROUND2() {

    }

    public void setInningRound(InningRound inningRound) {
        baseballInning.inningRound = inningRound;

        if(baseballInning.inningRound == InningRound.ROUND1) {
            onRoundChange();
            onROUND1();
        } else if(baseballInning.inningRound == InningRound.ROUND2) {
            onRoundChange();
            onROUND2();
        }
    }
}
