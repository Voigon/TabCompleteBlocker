package net.heks.tabcompleteblocker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	private final List<String>
			blockedCompletes = new ArrayList<>();
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		
		blockedCompletes.add("about");
		blockedCompletes.add("");
		
	}
	
	@EventHandler
	public void onTabComplete(TabCompleteEvent e) {
		for (String str : blockedCompletes)
			if (e.getBuffer().replaceFirst("/", "").startsWith(str))
				e.getCompletions().clear();
		
	}
}
