package com.goatgoose.mineball.Listeners;

import com.goatgoose.mineball.MineBall;
import com.goatgoose.mineball.Model.Baseball;
import com.goatgoose.mineball.Model.BaseballPlayer;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

    private MineBall plugin;

    public PlayerListener(MineBall instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {

        if(event.getEntity() instanceof Player) {
            BaseballPlayer shooter = plugin.getBaseballPlayer((Player)event.getEntity());
            Baseball baseball = new Baseball(plugin, (Arrow)event.getProjectile(), shooter);

            if(shooter == null) {
                event.setCancelled(true);
                return;
            }

            shooter.getPlayer().getInventory().remove(shooter.getPlayer().getItemInHand());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        BaseballPlayer baseballPlayer = plugin.getBaseballPlayer(event.getPlayer());

        Block block = baseballPlayer.getPlayer().getLocation().getBlock();

        if(baseballPlayer.getState() == BaseballPlayer.State.FIELDING) {
            Location playerCenter = baseballPlayer.getPlayer().getLocation();
            playerCenter.setY(baseballPlayer.getPlayer().getLocation().getY() + 1);
            baseballPlayer.setCatchBaseballHitboxCenter(playerCenter);
        }

        else if(baseballPlayer.getState() == BaseballPlayer.State.HITTING) {

        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        BaseballPlayer newBaseballPlayer = new BaseballPlayer(plugin, event.getPlayer(), BaseballPlayer.Team.WAITING);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            Player damager = (Player)event.getDamager();
            Player damaged = (Player)event.getEntity();
            net.minecraft.server.v1_7_R1.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(damager.getItemInHand());
            if(nmsItemStack.tag.getInt("MBBaseballItem") == 1) {

                BaseballPlayer baseballPlayerDamager = plugin.getBaseballPlayer(damager);
                BaseballPlayer baseballPlayerDamaged =plugin.getBaseballPlayer(damaged);

                if(baseballPlayerDamager == null || baseballPlayerDamaged == null) {
                    return;
                }

                baseballPlayerDamaged.baseballCatchEvent();
                baseballPlayerDamager.getPlayer().getInventory().remove(baseballPlayerDamager.getPlayer().getItemInHand());
            }
        }
    }

    // TODO log out event handler that removes the player from the list

}
