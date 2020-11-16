package com.yamiy.ayaka.config;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.yamiy.ayaka.handlers.AudioPlayerSendHandler;

public class GuildMusicManager {
	public final AudioPlayer player;
	public final TrackScheduler scheduler;

	/**
	* Creates a player and a track scheduler.
	* @param manager Audio player manager to use for creating the player.
	*/
	public GuildMusicManager(AudioPlayerManager manager) {
		player = manager.createPlayer();
		scheduler = new TrackScheduler(player);
		player.addListener(scheduler);
	}

	/**
	* @return Wrapper around AudioPlayer to use it as an AudioSendHandler.
	*/
	public AudioPlayerSendHandler getSendHandler() {
		return new AudioPlayerSendHandler(player);
	}
}
