package com.github.ifTNT.BTMFIP;

import java.util.logging.Logger;

import org.bukkit.BanList.Type;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	private Logger logger;
	
	@Override
	public void onEnable(){
		logger=getLogger();
		getServer().getPluginManager().registerEvents(this,this);
		logger.info("BanTheMotherFuckingIP");
		logger.info("Enable success  :)");
	}
	@Override
	public void onDisable(){
		logger.info("I have nothing to do");
		logger.info("So disable success XD");
	}
	@EventHandler
	private boolean onPlayerLogin(final PlayerLoginEvent e){
		if(e.getPlayer().isBanned()){
			if(!getServer().getIPBans().contains(e.getAddress().getHostAddress())){
				String IP=e.getAddress().getHostAddress();
				String PlayerName=e.getPlayer().getName();
				logger.info("Banned IP: "+IP);
				logger.info("Because of "+PlayerName);
				getServer().banIP(IP);
				e.disallow(Result.KICK_BANNED,"被Ban了還進來");
			}
		}
		return true;
	}
}
