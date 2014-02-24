package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BaseballItem {

    private MineBall plugin;

    private ItemStack bow;

    public BaseballItem(MineBall instance, ItemStack bow) {
        this.plugin = instance;
        this.bow = setItemName(bow, "Baseball");
    }

    public ItemStack getBow() {
        return bow;
    }

    public ItemStack setItemName(ItemStack itemStack, String name) {
        ItemMeta m = itemStack.getItemMeta();
        m.setDisplayName(name);
        itemStack.setItemMeta(m);
        return itemStack;
    }

}
