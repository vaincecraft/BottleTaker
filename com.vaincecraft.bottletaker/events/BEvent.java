package com.vaincecraft.bottletaker.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import com.vaincecraft.bottletaker.main.Main;

public class BEvent implements Listener {
	@EventHandler
	public void onEat(final PlayerItemConsumeEvent e) {
		if(!(e.getPlayer().hasPermission("bottletaker.bypass"))) {
			final ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					e.getPlayer().getInventory().removeItem(new ItemStack[] { bottle });
				}
			}, 2);
		}
	}
}
