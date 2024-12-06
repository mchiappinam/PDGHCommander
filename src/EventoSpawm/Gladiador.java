package EventoSpawm;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
//import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Gladiador extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static Gladiador plugin;
  public boolean antidc = true;
  public final AntiDC AD = new AntiDC(this);

  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " Foi Desativado!");
  }

  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " Foi Carregado!");
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(this.AD, this);
    getConfig().options().copyDefaults(true);
  }

  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("gladiador")) {
      if (args.length == 0) {
        if (sender.hasPermission("pdgheventospawn.use.gladiador"))
          sender.sendMessage(ChatColor.GOLD + "[PDGH] Anti-DC - Developed by: mchiappinam & GabrielM");
         else 
          sender.sendMessage(ChatColor.RED + "Você não tem permissões para executar esse comando!");
      }
      else if (args[0].equalsIgnoreCase("on")) {
        if (sender.hasPermission("pdgheventospawn.use.gladiador")) {
          this.antidc = true;
          sender.sendMessage(ChatColor.GOLD + "[PDGH]" + ChatColor.YELLOW + " Anti-DC - Status:" + ChatColor.DARK_GREEN + " [ON]");
        } else {
          sender.sendMessage(ChatColor.RED + "Você não tem permissões para executar esse comando!");
        }
      } else if (args[0].equalsIgnoreCase("off")) {
        if (sender.hasPermission("pdgheventospawn.use.gladiador")) {
          this.antidc = false;
          sender.sendMessage(ChatColor.GOLD + "[PDGH]" + ChatColor.YELLOW + " Anti-DC - Status:" + ChatColor.DARK_RED + " [OFF]");
        } else {
          sender.sendMessage(ChatColor.RED + "Você não tem permissão para executar esse comando!");
        }
      }
    }
    return false;
  }
}