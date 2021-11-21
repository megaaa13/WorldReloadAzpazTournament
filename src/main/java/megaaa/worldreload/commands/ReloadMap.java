package megaaa.worldreload.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ReloadMap implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        World w = Bukkit.getServer().getWorld("world1");
        for (Entity en : w.getEntities()) {
            if (en instanceof Player) {
                Player p = (Player) en;
                p.getInventory().clear();
                p.kickPlayer("§4T'es nul t'es mort !");
                p.teleport(w.getSpawnLocation());
                Bukkit.unloadWorld(w, false);
            }
        }
        w.setAutoSave(false);
        return true;
    }
}
