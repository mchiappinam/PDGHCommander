package EventoSpawm;

import org.bukkit.ChatColor;
import org.bukkit.Location;
//import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AntiDC
  implements Listener
{
  private Gladiador plugin;

  public AntiDC(Gladiador plugin)
  {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    if (this.plugin.antidc) {
      player.teleport(new Location(this.plugin.getServer().getWorld("world"), -1525.0D, 4.0D, 2066.0D));
      player.sendMessage(ChatColor.GOLD + "[Anti-DC] Você deslogou e foi teleportado para o spawn.");
    } else if (!this.plugin.antidc) {
      player.sendMessage(ChatColor.GOLD + "[PDGH] Bem vindo!");
    }
  }
}