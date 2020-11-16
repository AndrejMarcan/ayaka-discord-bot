package com.yamiy.ayaka.events;

import com.yamiy.ayaka.handlers.PlayerHandler;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PlayerEvent extends ListenerAdapter {
	PlayerHandler playerConfig = new PlayerHandler();
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
	    String[] command = event.getMessage().getContentRaw().split(" ", 2);

	    if ("~play".equals(command[0]) && command.length == 2) {
	    	playerConfig.loadAndPlay(event.getChannel(), command[1]);
	    } else if ("~skip".equals(command[0])) {
	    	playerConfig.skipTrack(event.getChannel());
	    }

	    super.onGuildMessageReceived(event);
	}
}
