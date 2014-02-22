package com.goatgoose.mineball.Model;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;

public class Baseball {

    Arrow arrow;

    public Baseball(Arrow arrow) {
        this.arrow = arrow;
    }

    public Arrow getArrow() {
        return arrow;
    }

}
