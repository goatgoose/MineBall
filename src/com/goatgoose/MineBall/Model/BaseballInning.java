package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;

public class BaseballInning {

    private MineBall plugin;

    private BaseballInningRoundManager baseballInningRoundManager;

    private int number;

    public BaseballInningRoundManager.InningRound inningRound;

    public BaseballInning(MineBall plugin, int number) {
        this.plugin = plugin;
        this.number = number;

        baseballInningRoundManager = new BaseballInningRoundManager(plugin, this);
        baseballInningRoundManager.setInningRound(BaseballInningRoundManager.InningRound.ROUND1);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
