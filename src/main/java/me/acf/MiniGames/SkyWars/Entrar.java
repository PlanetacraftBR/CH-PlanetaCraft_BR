package me.acf.MiniGames.SkyWars;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.SkyWars.kits.Kit;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.site.account.AccountWeb;

public class Entrar extends MiniPlugin {
	

	
	public Entrar(JavaPlugin plugin) {
	super("Entrar", plugin);
		// TODO Auto-generated constructor stub
	}
	
	public static int primeiro = 0;

	@EventHandler
	public void Entrou(PlayerJoinEvent event)
	{

		Player jogador = event.getPlayer();
		
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/SW.php?modo=ADD-conta&nick=" + jogador.getName()));
		
		Conta.Loader(jogador);
		
		jogador.getPlayer().getInventory().setHeldItemSlot(0);
		
		Kit.AddKit(jogador, "§9default ");
		

       if (Arcade.noInicio())
       {

    	   jogador.getInventory().clear();

    	   UtilInv.AddItem(event.getPlayer().getInventory(), false, Material.SAPLING, 1,(byte)0, "§bEscolher o mapa", 4);
    		
    	   UtilInv.AddItem(event.getPlayer().getInventory(), false, Material.CHEST, 1,(byte)0, "§aKit", 0);
    	   
    	   event.getPlayer().teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
       }
       

	}
	

}
