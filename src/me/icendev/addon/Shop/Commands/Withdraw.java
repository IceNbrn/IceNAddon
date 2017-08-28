package me.icendev.addon.Shop.Commands;

import me.icendev.addon.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Withdraw implements CommandExecutor{
    Main plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(plugin.name + ChatColor.RED + " This command only can be used by players!");
            return false;
        }
        if(args.length == 3){
            if(args[0].equalsIgnoreCase("give")){
                UUID senderP = ((Player) sender).getUniqueId();
                Player player;
                player = Bukkit.getPlayer(args[1]);
                if(player == null){
                    sender.sendMessage(ChatColor.RED + "Player not found!");
                    return false;
                }
                if(args[2] != null){
                    try {
                        if(Integer.parseInt(args[2]) > 0){

                            player.getInventory().addItem(
                                    plugin.createItem(new ItemStack(Material.STONE), "§b§lShard", new String[] { "Test", "Test2", "Test3", "Test3" }));
                            return true;
                        }
                    }catch (NumberFormatException e){
                        sender.sendMessage("Invalid number!");
                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "Try to use /coins give <player name> <amount>");
                    return false;
                }
            }
            sender.sendMessage(ChatColor.RED + "Try to use /coins give <player name> <amount>");
            return false;
        }

        return false;
    }
}
