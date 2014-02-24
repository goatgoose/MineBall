package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Tasks.BaseballManagerTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.inventory.ItemStack;

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

    public void replaceWithBaseballItem() {
        ItemStack bow = new ItemStack(Material.BOW);
        BaseballItem baseballItem = new BaseballItem(plugin, bow);
        arrow.getWorld().dropItem(arrow.getLocation(), baseballItem.getBow());
        arrow.remove();
    }

}
