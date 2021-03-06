/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Phantom extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Phantom(JavaPlugin plugin) {
		super("Kit Phantom", plugin);
		// TODO Auto-generated constructor stub
	}
	
	  @EventHandler
	  public void voar(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((e.getAction().name().contains("RIGHT")) && 
	      (p.getItemInHand().getType() == Material.FEATHER))
	    {
	    	if (Kit.PoderUsar(p, "phantom")) {
	      e.setCancelled(true);
	      p.updateInventory();
	  	   if (!Recharge.Instance.use(p, "phantom", 26900L, true, false)) {
               return;
             }
	  	    p.setAllowFlight(true);
	        p.setFlying(true);
	        UtilSound.playSound(p, Sounds.ENDERDRAGON_GROWL, 1.0F, 3.0F); 
	        for (Entity ent : p.getNearbyEntities(6.0D, 2.0D, 6.0D)) {
                if ((ent instanceof Player))
                {
                    UtilSound.playSound(((Player) ent), Sounds.ENDERDRAGON_GROWL, 1.0F, 3.0F);   	
                }
	        }
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	         UtilSound.playSound(p, Sounds.ENDERDRAGON_HIT, 1.0F, 3.0F);
	         p.setFlying(false);
	         p.setAllowFlight(false);
	         p.setFallDistance(0);
	          }
	        }, 100L);
	    	}
	    }
	  }

}
