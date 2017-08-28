package me.icendev.addon;


import me.icendev.addon.IceShards.Commands.Withdraw;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin{

    PluginDescriptionFile file = this.getDescription();

    public String name = ChatColor.AQUA + "[" + file.getName() + "]";

    public void onEnable(){
        getCommand("coins").setExecutor(new Withdraw());
        Bukkit.getConsoleSender().sendMessage(name + ChatColor.GREEN  + " Plugin loaded with success");
    }

    public ItemStack createItem(ItemStack item, String name, String[] lore) {
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        if(lore != null){
            im.setLore(Arrays.asList(lore));
        }
        item.setItemMeta(im);
        return item;
    }
}
