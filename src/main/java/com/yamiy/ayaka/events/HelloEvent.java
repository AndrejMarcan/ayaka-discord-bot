package com.yamiy.ayaka.events;

import java.util.Optional;

import com.yamiy.ayaka.utils.Constants;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {
	
	/** Method answer in server chat after someone writes there */
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(!event.getAuthor().isBot() && isGreetingMessage(event.getMessage().getContentRaw())){
			event.getChannel().sendMessage("Hello " + event.getAuthor().getAsMention() + ". How are you ?").queue();
		}	
	}
	
	/** Method answer in private chat after someone writes there */
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
		if (event.isFromType(ChannelType.PRIVATE)) {
			if(!event.getAuthor().isBot() && isGreetingMessage(event.getMessage().getContentRaw())) {
				event.getChannel().sendMessage("Hello " + event.getAuthor().getAsMention() + ". How are you ?").queue();
			}
		}
    }
	
	private boolean isGreetingMessage(String message) {
		Optional<String> greeting = Constants.GREETINGS.stream().filter(m -> message.equalsIgnoreCase(m)).findFirst();
		return greeting.isPresent();
	}
}