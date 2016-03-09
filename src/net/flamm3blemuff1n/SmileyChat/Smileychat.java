package net.flamm3blemuff1n.SmileyChat;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

import net.flamm3blemuff1n.SmileyChat.UpdateChecker.UpdateResult;
import net.flamm3blemuff1n.SmileyChat.UpdateChecker.UpdateType;
import net.minecraft.server.v1_9_R1.SharedConstants;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Smileychat extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Smileychat plugin;
	private PlayerListener PlayerListener = new PlayerListener(this);
	private HeroSmileys HeroSmileys = new HeroSmileys(this);
	protected Logger log;
	protected UpdateChecker updateChecker;
	static Smileychat instance;
	
	
	@Override
	// enable
	public void onEnable(){
		
		this.log = this.getLogger();
		
		if(this.getConfig().getBoolean("Update-check") == true){
			this.updateChecker = new UpdateChecker(this, 57551, this.getFile(), UpdateType.NO_DOWNLOAD, false);
			if(this.updateChecker.getResult() == UpdateResult.UPDATE_AVAILABLE){
				System.out.println("[SmileyChat] A new Version is available: " + this.updateChecker.getLatestName());
				
				System.out.println("[SmileyChat] Get it from: http://dev.bukkit.org/bukkit-plugins/smileychat/");
			}
		}
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
		
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.print("[SmileyChat] version " + pdfFile.getVersion() + " Has been Enabled!");
		PluginManager pm = getServer().getPluginManager();
		
		if (getServer().getPluginManager().getPlugin("Herochat") != null){
				pm.registerEvents(this.HeroSmileys, this);
				System.out.println("[SmileyChat] Using: Herochat!");
		} else if(getServer().getPluginManager().getPlugin("HeroChat") == null){
			pm.registerEvents(this.PlayerListener, this);
			System.out.println("[SmileyChat] Using: Normal Minecraft Chat.");
		}
		this.saveDefaultConfig();
		pm.registerEvents(this, this);
	}
	@Override
	// disable
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been Disabled!");	
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(player.hasPermission("smileychat.update")){
			if(this.getConfig().getBoolean("Update-check") == true){
				this.updateChecker = new UpdateChecker(this, 57551, this.getFile(), UpdateType.NO_DOWNLOAD, false);
				if(this.updateChecker.getResult() == UpdateResult.UPDATE_AVAILABLE){
					player.sendMessage(ChatColor.DARK_PURPLE + "[SmileyChat]" + ChatColor.AQUA + " A new Version is available: " + this.updateChecker.getLatestName());
					player.sendMessage(ChatColor.DARK_PURPLE + "[SmileyChat]" + ChatColor.AQUA + " Get it from: http://dev.bukkit.org/bukkit-plugins/smileychat/");
				}
			}
		}
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("smileychat")){
			if (args.length == 0) {
				if(sender.hasPermission("smileychat.info")){
        			sender.sendMessage(ChatColor.DARK_GREEN + "+------------------------------+");
        			sender.sendMessage(ChatColor.AQUA +  "SmileyChat");
        			sender.sendMessage(ChatColor.AQUA +      "By flamm3blemuff1n");
        			sender.sendMessage(ChatColor.YELLOW +     "Version: " + this.getDescription().getVersion());
        			sender.sendMessage(ChatColor.DARK_GREEN + "+------------------------------+");
        		}else if(sender.getName().equals("flamm3blemuff1n")){
        			sender.sendMessage(ChatColor.DARK_GREEN + "+------------------------------+");
        			sender.sendMessage(ChatColor.AQUA +  "SmileyChat");
        			sender.sendMessage(ChatColor.AQUA +      "Server Has installed Smileychat succesfully!");
        			sender.sendMessage(ChatColor.YELLOW +     "Version: " + this.getDescription().getVersion());
        			sender.sendMessage(ChatColor.DARK_GREEN + "+------------------------------+");
        		}
			}
			if (args.length == 1){
				if (args[0].equalsIgnoreCase("reload")) {
					if(sender.hasPermission("smileychat.reload")){
	        			reloadConfig();
	                    sender.sendMessage(ChatColor.AQUA + "[Smileychat] Plugin reloaded!");
	                    System.out.print("[smileychat] Reloaded!");
	        		}
				}else if(args[0].equalsIgnoreCase("art")){
					if(sender.hasPermission("smileychat.list")){
						int x = 0;
						sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
						while(x < net.flamm3blemuff1n.SmileyChat.Smileys.art.length){
							sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.art[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]));
							x++;
						}
					}
				}
			}
			if (args.length == 2){
				if (args[0].equalsIgnoreCase("smileys")){
					if(sender.hasPermission("smileychat.list")){
						if (args[1].equalsIgnoreCase("misc")){
							int x = 0;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < 35){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
								x++;
							}
						}else if(args[1].equalsIgnoreCase("weather")){
							int x = 35;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < 47){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
								x++;
							}
						}else if(args[1].equalsIgnoreCase("cards")){
							int x = 47;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < 55){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
								x++;
							}
						}else if(args[1].equalsIgnoreCase("directions")){
							int x = 55;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < 63){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
								x++;
							}
						}else if(args[1].equalsIgnoreCase("chess")){
							int x = 63;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < 75){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
								x++;
							}
						}else if(args[1].equalsIgnoreCase("zod")){
							int x = 75;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < 87){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
								x++;
							}
						}
					}
				}
			}
		}
		
		if(this.getConfig().getBoolean("use-alias-sc") == true){
			if(label.equalsIgnoreCase("sc")){
				if (args.length == 0) {
					if(sender.hasPermission("smileychat.info")){
	        			sender.sendMessage(ChatColor.DARK_GREEN + "+------------------------------+");
	        			sender.sendMessage(ChatColor.AQUA +  "SmileyChat");
	        			sender.sendMessage(ChatColor.AQUA +      "By flamm3blemuff1n");
	        			sender.sendMessage(ChatColor.YELLOW +     "Version:" + this.getDescription().getVersion());
	        			sender.sendMessage(ChatColor.DARK_GREEN + "+------------------------------+");
	        		}
				}
				if (args.length == 1){
					if (args[0].equalsIgnoreCase("reload")) {
						if(sender.hasPermission("smileychat.reload")){
		        			reloadConfig();
		                    sender.sendMessage(ChatColor.AQUA + "[Smileychat] Plugin reloaded!");
		                    System.out.print("[smileychat] Reloaded!");
		        		}
					}else if(args[0].equalsIgnoreCase("art")){
						if(sender.hasPermission("smileychat.list")){
							int x = 0;
							sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
							while(x < net.flamm3blemuff1n.SmileyChat.Smileys.art.length){
								sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.art[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]));
								x++;
							}
						}
					}
				}
				if (args.length == 2){
					if (args[0].equalsIgnoreCase("smileys")){
						if(sender.hasPermission("smileychat.list")){
							if (args[1].equalsIgnoreCase("misc")){
								int x = 0;
								sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
								while(x < 35){
									sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
									x++;
								}
							}else if(args[1].equalsIgnoreCase("weather")){
								int x = 35;
								sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
								while(x < 47){
									sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
									x++;
								}
							}else if(args[1].equalsIgnoreCase("cards")){
								int x = 47;
								sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
								while(x < 55){
									sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
									x++;
								}
							}else if(args[1].equalsIgnoreCase("directions")){
								int x = 55;
								sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
								while(x < 63){
									sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
									x++;
								}
							}else if(args[1].equalsIgnoreCase("chess")){
								int x = 63;
								sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
								while(x < 75){
									sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
									x++;
								}
							}else if(args[1].equalsIgnoreCase("zod")){
								int x = 75;
								sender.sendMessage(ChatColor.AQUA + "---[Smileychat] List---");
								while(x < 87){
									sender.sendMessage(ChatColor.YELLOW + net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x] + " : " + ChatColor.AQUA +this.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]));
									x++;
								}
							}
						}
					}
				}
			}
		}
        return false;
	}        
	
	 public void ModifyAllowedCharacters() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	  Field field = SharedConstants.class.getDeclaredField("allowedCharacters");
	  field.setAccessible(true);
	  Field modifiersField = Field.class.getDeclaredField( "modifiers" );
	  modifiersField.setAccessible( true );
	  modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
	  String oldallowedchars = (String)field.get(null);
	  String suits = "\u2665\u2666\u2663\u2660";
	  StringBuilder sb = new StringBuilder();
	  sb.append( oldallowedchars );
	  sb.append( suits );
	  field.set( null, sb.toString() );
	 }
}