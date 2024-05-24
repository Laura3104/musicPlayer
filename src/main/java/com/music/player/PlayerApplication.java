package com.music.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PlayerApplication {

	public static void main(String[] args) {
		List<String> trackList = List.of("Track 1", "Track 2", "Track 3", "Track 4");
		MusicPlayer musicPlayer = new MusicPlayer(trackList);

		musicPlayer.playOrPause();
		musicPlayer.next();
		musicPlayer.next();
		musicPlayer.next();
		musicPlayer.next();
		musicPlayer.stop();
		musicPlayer.stop();
		musicPlayer.previous();
		musicPlayer.stop();
		musicPlayer.repeatOnOrOff();

	}

}
