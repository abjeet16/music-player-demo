package com.example.animal;

import static com.example.animal.playSound.musicPlayer;

import java.util.concurrent.TimeUnit;

public class ConverTime {
    public static int duration;
    public static String time,currentTime;
    void convertDuraction() {
        duration = musicPlayer.getDuration();
        time = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
    }
    void currentTime() {
        duration = musicPlayer.getCurrentPosition();
        currentTime = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
    }

}
