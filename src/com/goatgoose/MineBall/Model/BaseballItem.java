package com.goatgoose.mineball.Model;

import com.goatgoose.mineball.MineBall;
import net.minecraft.server.v1_7_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BaseballItem {

    private MineBall plugin;

    private ItemStack bow;

    public BaseballItem(MineBall instance, ItemStack bow) {
        this.plugin = instance;
        this.bow = bow;

        this.bow = setItemName(this.bow, "Baseball");


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
