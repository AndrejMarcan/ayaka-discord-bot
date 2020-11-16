package com.yamiy.ayaka.config;

import javax.security.auth.login.LoginException;

import com.yamiy.ayaka.events.HelloEvent;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class JDABasicConfig {
	/** token here is invalid, you have to get your own drom https://discord.com/developers/applications */
	private static final String token = "Nzc0OTIxNjE0MjAxNTg1NzE0.X6ez_g.kbQKqiGj4YtgorHvVmgPX659I8A";
	
	public static JDABuilder buildJDA() throws LoginException {
		JDABuilder jda = JDABuilder.createDefault(
				token, 
				GatewayIntent.GUILD_MESSAGES,
				GatewayIntent.DIRECT_MESSAGES);
		jda.addEventListeners(new HelloEvent());
		jda.build();
		
		return jda;
	}
}
