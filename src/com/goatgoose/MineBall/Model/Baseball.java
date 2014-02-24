package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Tasks.BaseballManagerTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;

public class Baseball {

    private MineBall plugin;

    private Arrow arrow;

    private BaseballPlayer owner;

    private BaseballManagerTask task;

    public Baseball(MineBall instance, Arrow arrow, BaseballPlayer owner) {
        this.plugin = instance;
        this.arrow = arrow;
        this.owner = owner;
        this.task = new BaseballManagerTask(plugin, this, this.owner);
    }

    public Arrow getArrow() {
        return arrow;
    }

}
