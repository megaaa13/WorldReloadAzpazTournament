package megaaa.worldreload;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Bukkit.getServer().createWorld(new WorldCreator("world1"));
        Bukkit.getWorld("world1").setAutoSave(false);
        e.getPlayer().setHealth(20);
        e.getPlayer().setFoodLevel(20);
        e.getPlayer().setSaturation(20);
        e.getPlayer().setFireTicks(0);
        e.getPlayer().setFallDistance(0);
        e.getPlayer().setGameMode(GameMode.SURVIVAL);
        Location loc = new Location(Bukkit.getServer().getWorld("world1"), -247.5, 105, 49.5, 180, 0);
        e.getPlayer().teleport(loc);
    }
    @EventHandler
    public void onFire(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.LAVA) {
            if (e.getEntity() instanceof Player) {
                Player player = (Player) e.getEntity();
                player.performCommand("rm");
            }
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = (Player) e.getEntity();
        player.sendRawMessage("§aDéco-reco, fais /rm et c'est bon ! (oui c'est la galère)");
    }
}
