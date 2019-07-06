package io.github.pzrc.nethercoords;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class NetherCoords extends JavaPlugin {

    private NetherCoords pl = this;

    @Override
    public void onEnable() {
        this.getCommand("coords").setExecutor(pl);
    }

    @Override
    public void onDisable() {
        pl = null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location coords = player.getLocation();

            int x = coords.getBlockX();
            int y = coords.getBlockY();
            int z = coords.getBlockZ();

            if (!(player.getWorld().getName().equals("world_nether"))) {
                sender.sendMessage(ChatColor.GREEN + "Your overworld coordinates are: " + x + ", " + y + ", " + z);
                sender.sendMessage(ChatColor.GREEN + "Your nether coordinates would be: "
                        + Math.round(x / 8) + ", "
                        + y + ", "
                        + Math.round(z / 8));
            } else if (player.getWorld().getName().equals("world_nether")) {
                sender.sendMessage(ChatColor.GREEN + "Your nether coordinates are: " + x + ", " + y + ", " + z);
                sender.sendMessage(ChatColor.GREEN + "Your overworld coordinates would be: "
                        + Math.round(x * 8) + ", "
                        + y + ", "
                        + Math.round(z * 8));
            }

            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This command is only usable by players!");
            return true;
        }
    }
}
