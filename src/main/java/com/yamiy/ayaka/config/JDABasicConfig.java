package com.yamiy.ayaka.config;

import javax.security.auth.login.LoginException;

import com.yamiy.ayaka.events.HelloEvent;
import com.yamiy.ayaka.events.PlayerEvent;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class JDABasicConfig {
	/** token here is invalid, you have to get your own drom https://discord.com/developers/applications */
	//private static final String token = "Nzc0OTIxNjE0MjAxNTg1NzE0.X6ez_g.kbQKqiGj4YtgorHvVmgPX659I8A";
	private static final String token = "Nzc0OTIxNjE0MjAxNTg1NzE0.X6ez_g.-ioFxLp72gBca1reS9A6ipWSXRM";
	
	public static JDABuilder buildJDA() throws LoginException {
		JDABuilder jda = JDABuilder.createDefault(
				token, 
				GatewayIntent.GUILD_MESSAGES,
				GatewayIntent.DIRECT_MESSAGES,
				GatewayIntent.GUILD_VOICE_STATES);
		jda.addEventListeners(new HelloEvent(), new PlayerEvent());
		jda.build();
		
		return jda;
	}
}
