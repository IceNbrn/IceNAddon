package me.icendev.addon.IceShards.Commands;

import me.icendev.addon.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

public class Withdraw implements CommandExecutor{
    Main plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(plugin.name + ChatColor.RED + " This command only can be used by players!");
            return false;
        }
        if(args[0].equalsIgnoreCase("give")){

            UUID senderP = ((Player) sender).getUniqueId();
            Player player;
            player = Bukkit.getPlayer(args[1]);

            if(player == null){
                sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GRAY + args[1] + ChatColor.RED + " not found!");
                return false;
            }
            if(args.length == 3){

                try {
                    if(Integer.parseInt(args[2]) > 0){

                        String[] lore = new String[] { "Test", "Test2", "Test3", "Test3" };
                        String[] lore2 = new String[] { ChatColor.GRAY + "by IceN" };
                        String[] lore3 = new String[] { ChatColor.GREEN + "______________", ChatColor.GRAY + "Signed by " + ChatColor.GREEN + sender.getName(), ChatColor.GREEN + "----------" };
                        player.getInventory().addItem(
                                plugin.createItem(new ItemStack(Material.PRISMARINE_CRYSTALS,Integer.parseInt(args[2])), "§b§lIceCrystals", lore));
                        player.getInventory().addItem(
                                plugin.createItem(new ItemStack(Material.PRISMARINE_SHARD,Integer.parseInt(args[2])), "§b§lIceShard", lore2));
                        player.getInventory().addItem(
                                plugin.createItem(new ItemStack(Material.PAPER,1), "§a§lBank Note " + ChatColor.AQUA + "($" + args[2] + ")", lore3));
                        return true;
                    }
                }catch (NumberFormatException e){
                    sender.sendMessage("Invalid number!");
                    return false;
                }
            }else{
                sender.sendMessage(ChatColor.RED + "Try to use /coins give <player name> <amount>");
                return false;
            }
        }else if(args[0].equalsIgnoreCase("help")){
            sender.sendMessage(" ");
            sender.sendMessage("§c§lIceShards Help:");
            sender.sendMessage(" ");
            sender.sendMessage(ChatColor.GREEN + "/coins give <player> <amount> " + ChatColor.GRAY + "- Use this command to give coins to others players");
            sender.sendMessage(ChatColor.GREEN + "/coins help " + ChatColor.GRAY + "- List all commands of coins");
            return true;
        }else if(args[0].equalsIgnoreCase("check")){
            sender.sendMessage("hi");
            Inventory i = ((Player) sender).getInventory();
            sender.sendMessage("h2");
            for (ItemStack inven : i.getContents()) {
                sender.sendMessage("h3");
                if (inven.getItemMeta().hasLore() ) {
                    //sender.sendMessage(inven.getItemMeta().getDisplayName());
                    /*if (lore.contains("Signed by") && meta.getDisplayName().contains("§a§lBank Note")) {
                        //String money = meta.getDisplayName().replace("§a§lBank Note (", "");
                        //sender.sendMessage(money);
                        sender.sendMessage("2");


                    }*/
                    sender.sendMessage("pls");
                    return true;
                }
                sender.sendMessage("Teste");
                return false;
            }
            sender.sendMessage("052");
            return false;
        }else{
            sender.sendMessage(ChatColor.RED + "Invalid argument " + ChatColor.GREEN + args[0] + ". " + "Try to use /coins help");
            return false;
        }
        return false;

    }
}
