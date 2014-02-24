package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Tasks.BaseballManagerTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;

public class Baseball {

    MineBall plugin;

    Arrow arrow;

    BaseballManagerTask task;

    public Baseball(Arrow arrow, MineBall instance) {
        this.plugin = instance;
        this.arrow = arrow;
        this.task = new BaseballManagerTask(plugin, this);
    }

    public Arrow getArrow() {
        return arrow;
    }

}
