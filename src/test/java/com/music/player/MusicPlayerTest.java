package com.music.player;

import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class MusicPlayerTest {

    private MusicPlayer musicPlayer;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        List<String> tracks = Arrays.asList("Track 1", "Track 2", "Track 3");
        musicPlayer = new MusicPlayer(tracks);
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testPlayOrPause() {
        musicPlayer.playOrPause();
        Assert.assertEquals("Playing: Track 1\n", outContent.toString());
        outContent.reset();

        musicPlayer.playOrPause();
        Assert.assertEquals("Pausing: Track 1\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testStop() {
        musicPlayer.playOrPause();
        outContent.reset();

        musicPlayer.stop();
        Assert.assertEquals("Stopping: Track 1\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testNext(){
        musicPlayer.next();
        Assert.assertEquals("Playing next track: Track 2\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testPrevious(){
        musicPlayer.next();
        outContent.reset();

        musicPlayer.previous();
        Assert.assertEquals("Playing previous track: Track 1\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testRepeatOnOrOff(){
        musicPlayer.repeatOnOrOff();
        Assert.assertEquals("Repeat on\n" , outContent.toString());
        outContent.reset();
    }

}
