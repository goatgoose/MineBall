package com.goatgoose.mineball.Events;

import com.goatgoose.mineball.Model.Baseball;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BaseballMoveEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    private Baseball baseball;

    public BaseballMoveEvent(Baseball baseball) {
        this.baseball = baseball;
    }

    public Baseball getBaseball() {
        return baseball;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean bln) {
        this.cancelled = bln;
    }

}
