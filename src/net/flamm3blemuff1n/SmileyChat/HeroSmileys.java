package net.flamm3blemuff1n.SmileyChat;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import com.dthielke.herochat.ChannelChatEvent;

public class HeroSmileys implements Listener{

	public Smileychat plugin;
	public HeroSmileys(Smileychat instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onHeroChat(ChannelChatEvent event){
		String message = event.getMessage();
		
		if(this.plugin.getConfig().getBoolean("chat") == true){
			if(event.getSender().getPlayer().hasPermission("smileychat.chat.smileys")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.names.length){
					message = message.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
					event.setMessage(message);
					x++;
				}
			}
			if(event.getSender().getPlayer().hasPermission("smileychat.chat.art")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.nameart.length){
					message = message.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
					event.setMessage(message);
					x++;
				}
			}
			if(event.getSender().getPlayer().hasPermission("smileychat.chat.custom")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.custominput.length){
					message = message.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]));
					event.setMessage(message);
					x++;
				}
			}
		}
	}
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event){
		String command = event.getMessage();
		
		if(this.plugin.getConfig().getBoolean("Use-commands") == true){
			if(event.getPlayer().hasPermission("smileychat.command.smileys")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.names.length){
					command = command.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
					event.setMessage(command);
					x++;
				}
			}
			if(event.getPlayer().hasPermission("smileychat.command.art")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.nameart.length){
					command = command.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
					event.setMessage(command);
					x++;
				}
			}
			if(event.getPlayer().hasPermission("smileychat.command.custom")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.custominput.length){
					command = command.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]));
					event.setMessage(command);
					x++;
				}
			}
		}
	}
	@EventHandler
	public void onSignCreate(SignChangeEvent sign){
		if(this.plugin.getConfig().getBoolean("Use-signs") == true){
			String sign0 = sign.getLine(0);
			String sign1 = sign.getLine(1);
			String sign2 = sign.getLine(2);
			String sign3 = sign.getLine(3);
			
			if(sign.getPlayer().hasPermission("smileychat.sign.smileys")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.names.length){
				sign0 = sign0.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
				sign1 = sign1.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
				sign2 = sign2.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
				sign3 = sign3.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
				
				sign.setLine(0, sign0);
				sign.setLine(1, sign1);
				sign.setLine(2, sign2);
				sign.setLine(3, sign3);
				x++;
				}
			}
			if(sign.getPlayer().hasPermission("smileychat.sign.art")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.nameart.length){
					sign0 = sign0.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
					sign1 = sign1.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
					sign2 = sign2.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
					sign3 = sign3.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
					
					sign.setLine(0, sign0);
					sign.setLine(1, sign1);
					sign.setLine(2, sign2);
					sign.setLine(3, sign3);
					x++;
				}
			}
			if(sign.getPlayer().hasPermission("smileychat.sign.custom")){
				int x = 0;
				while(x < net.flamm3blemuff1n.SmileyChat.Smileys.custominput.length){
					sign0 = sign0.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]));
					sign1 = sign1.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]));
					sign2 = sign2.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]));
					sign3 = sign3.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]));
					
					sign.setLine(0, sign0);
					sign.setLine(1, sign1);
					sign.setLine(2, sign2);
					sign.setLine(3, sign3);
					x++;
				}
			}
		}
	}
	@EventHandler
	public void OnBookCreate(PlayerEditBookEvent event){
		BookMeta bm = event.getNewBookMeta();
		String Author = bm.getAuthor();
		String Title = bm.getTitle();
		
		if(this.plugin.getConfig().getBoolean("Use-books") == true){
			if(event.getPlayer().hasPermission("smileychat.book.smileys")){
				if(bm.hasAuthor()){
					int x = 0;
					while(x < net.flamm3blemuff1n.SmileyChat.Smileys.names.length){
						Author = Author.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
						bm.setAuthor(Author);
						x++;
					}
				}
				if(bm.hasTitle()){
					int x = 0;
					while(x < net.flamm3blemuff1n.SmileyChat.Smileys.names.length){
						Title = Title.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
						bm.setTitle(Title);
						x++;
					}
				}
				if ((bm.hasPages()) && (bm.getPages().size() > 0)){
					List<String> pages = bm.getPages();
					List<String> newPages = new ArrayList<String>(pages.size());
					for(String page : pages){
						int x = 0;
						while(x < net.flamm3blemuff1n.SmileyChat.Smileys.names.length){
							page = page.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.names[x]), net.flamm3blemuff1n.SmileyChat.Smileys.smiley[x]);
							x++;
						}
						newPages.add(page);
					}
					bm.setPages(newPages);	
				}	
			}
			if(event.getPlayer().hasPermission("smileychat.book.art")){
				if(bm.hasAuthor()){
					int x = 0;
					while(x < net.flamm3blemuff1n.SmileyChat.Smileys.nameart.length){
						Author = Author.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
						bm.setAuthor(Author);
						x++;
					}
				}
				if(bm.hasTitle()){
					int x = 0;
					while(x < net.flamm3blemuff1n.SmileyChat.Smileys.nameart.length){
						Title = Title.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
						bm.setTitle(Title);
						x++;
					}
				}
				if ((bm.hasPages()) && (bm.getPages().size() > 0)){
					List<String> pages = bm.getPages();
					List<String> newPages = new ArrayList<String>(pages.size());
					for(String page : pages){
						int x = 0;
						while(x < net.flamm3blemuff1n.SmileyChat.Smileys.nameart.length){
							page = page.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.nameart[x]), net.flamm3blemuff1n.SmileyChat.Smileys.art[x]);
							x++;
						}
						newPages.add(page);
					}
					bm.setPages(newPages);
			    }
			}
			if(event.getPlayer().hasPermission("smileychat.book.custom")){
				if(bm.hasAuthor()){
					int x = 0;
					while(x < net.flamm3blemuff1n.SmileyChat.Smileys.custominput.length){
						Author = Author.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]);
						bm.setAuthor(Author);
						x++;
					}
				}
				if(bm.hasTitle()){
					int x = 0;
					while(x < net.flamm3blemuff1n.SmileyChat.Smileys.custominput.length){
						Title = Title.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]);
						bm.setTitle(Title);
						x++;
					}
				}
				if ((bm.hasPages()) && (bm.getPages().size() > 0)){
					List<String> pages = bm.getPages();
					List<String> newPages = new ArrayList<String>(pages.size());
					for(String page : pages){
						int x = 0;
						while(x < net.flamm3blemuff1n.SmileyChat.Smileys.custominput.length){
							page = page.replace(plugin.getConfig().getString(net.flamm3blemuff1n.SmileyChat.Smileys.custominput[x]), net.flamm3blemuff1n.SmileyChat.Smileys.customoutput[x]);
							x++;
						}
						newPages.add(page);
					}
					bm.setPages(newPages);
			    }
			}
		}
		event.setNewBookMeta(bm);
	}
}
