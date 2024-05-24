package com.music.player;

import java.util.List;

public class MusicPlayer implements Player{

    private List<String> listOfTracks;
    private int currentTrackIndex;
    private boolean isPlaying;
    private boolean isStopped;
    private boolean repeat;

    public MusicPlayer(List<String> listOfTracks) {
        this.listOfTracks = listOfTracks;
        this.currentTrackIndex = 0;
        this.isPlaying = false;
        this.isStopped = true;
        this.repeat = false;
    }

    @Override
    public void playOrPause() {
        if(isPlaying) {
            System.out.println("Pausing: " + listOfTracks.get(currentTrackIndex));
            isStopped = true;
        }else {
            System.out.println("Playing: " + listOfTracks.get(currentTrackIndex));
            isStopped = false;
            isPlaying = true;
        }
    }

    @Override
    public void stop() {
        if(isStopped){
            System.out.println("Track already stopped");
        }else{
            System.out.println("Stopping: " + listOfTracks.get(currentTrackIndex));
            isPlaying = false;
            isStopped = true;
        }
    }

    @Override
    public void next() {
        if (currentTrackIndex < listOfTracks.size() - 1) {
            currentTrackIndex++;
            System.out.println("Playing next track: " + listOfTracks.get(currentTrackIndex));
            isPlaying = true;
            isStopped = false;
        }else{
            if (repeat) {
                System.out.println("Replaying track: " + listOfTracks.get(currentTrackIndex));
                isPlaying = true;
                isStopped = false;
            } else {
                System.out.println("Already on the last track");
            }
        }

    }

    @Override
    public void previous() {
        if (currentTrackIndex > 0){
            currentTrackIndex--;
            System.out.println("Playing previous track: " + listOfTracks.get(currentTrackIndex));
            isPlaying = true;
            isStopped = false;
        } else {
            System.out.println("Already first track");
        }

    }

    @Override
    public void repeatOnOrOff() {
        repeat = !repeat;
        if (repeat) {
            System.out.println("Repeat on");
        } else {
            System.out.println("Repeat off");
        }
    }
}
