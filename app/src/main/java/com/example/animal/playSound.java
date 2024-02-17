package com.example.animal;

import static com.example.animal.ConverTime.currentTime;
import static com.example.animal.ConverTime.time;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class playSound extends AppCompatActivity {


    ImageButton start, reset,tenFront,tenBack;
    ImageView SongImage;
    SeekBar seekBar;
    LinearLayout layout;
    TextView duration, Current,songName;
    int PlayPauseCount = 0;
    static MediaPlayer musicPlayer;
    boolean running;
    Thread UpdateSeekBar;
    ImageButton nextButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        //find ids of View
        findIDs();

        if (musicPlayer != null) {
            musicPlayer.stop();
            musicPlayer.release();
        }
        Intent intent = getIntent();

        String onlinePath = intent.getStringExtra("link");
        String songname = intent.getStringExtra("songname");
        String posString= intent.getStringExtra("pos");
        int position = Integer.parseInt(posString);

        //set musicImage
        setSongImage(position);


        musicPlayer = new MediaPlayer();
        musicPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri onlineMusicPath = Uri.parse(onlinePath);
        try {
            musicPlayer.setDataSource(this, onlineMusicPath);
            musicPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //set song name
        songName.setText(songname);
        //set the song duration
        ConverTime converTime = new ConverTime();
        converTime.convertDuraction();
        duration.setText(time);
        //

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayPauseCount == 0) {
                    musicPlayer.start();
                    start.setBackgroundResource(R.drawable.pause);
                    running = true;
                    PlayPauseCount++;
                    UpdateSeekBar = new Thread(){
                        @Override
                        public void run() {
                            int totalduration = musicPlayer.getDuration();
                            int currentPostion =0;
                            while (currentPostion<totalduration){
                                try {
                                    sleep(500);
                                    currentPostion = musicPlayer.getCurrentPosition();
                                    seekBar.setProgress(currentPostion);
                                }catch (InterruptedException | IllegalStateException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                    seekBar.setMax(musicPlayer.getDuration());
                    UpdateSeekBar.start();
                } else {
                    musicPlayer.pause();
                    start.setBackgroundResource(R.drawable.baseline_play_arrow_24);
                    PlayPauseCount = 0;
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicPlayer.pause();
                start.setBackgroundResource(R.drawable.baseline_play_arrow_24);
                musicPlayer.seekTo(0);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                musicPlayer.seekTo(seekBar.getProgress());
            }
        });

        final Handler handler = new Handler();
        final  int dilay = 500;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                converTime.currentTime();
                Current.setText(currentTime);
                handler.postDelayed(this,dilay);
            }
        },dilay);
        tenFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tensec = 10000;
                int currentTime = musicPlayer.getCurrentPosition();
                int totalTime = musicPlayer.getDuration();
                int seektoten = currentTime + tensec;
                if(currentTime>totalTime)
                    Current.setText(time);
                else
                musicPlayer.seekTo(seektoten);
            }
        });
        tenBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tensec = 10000;
                int currentTime = musicPlayer.getCurrentPosition();
                int seekbackten = currentTime - tensec;
                if(currentTime<0)
                    musicPlayer.seekTo(0);
                else
                musicPlayer.seekTo(seekbackten);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                9uhafvhaha
            }
        });
    }
    void setSongImage(int pos) {
        if (pos == 1)
            SongImage.setImageResource(R.drawable.arjanvaily);
        else if (pos == 2)
            SongImage.setImageResource(R.drawable.haiwaan);
        else if (pos == 3)
            SongImage.setImageResource(R.drawable.papamarejaan);
        else if (pos == 4)
            SongImage.setImageResource(R.drawable.huamain);
        else if (pos == 5)
            SongImage.setImageResource(R.drawable.satranga);
        else if (pos == 6)
            SongImage.setImageResource(R.drawable.kasmirr);
        else if (pos == 7)
            SongImage.setImageResource(R.drawable.pehlebhi);
        else if (pos == 8)
            SongImage.setImageResource(R.drawable.saariduniyajalaadenge);
        else if (pos == 9)
            SongImage.setImageResource(R.drawable.abrarentryy);
        else if (pos == 10)
            SongImage.setImageResource(R.drawable.dolbywalya);
    }
    void findIDs(){
        start = findViewById(R.id.Start);
        reset = findViewById(R.id.reset);
        layout = findViewById(R.id.layout);
        duration = findViewById(R.id.songDuration);
        Current = findViewById(R.id.currentTime);
        seekBar = findViewById(R.id.seekbar);
        tenBack = findViewById(R.id.tenbacward);
        tenFront = findViewById(R.id.tenForward);
        songName = findViewById(R.id.Songname);
        SongImage = findViewById(R.id.songImage);
        nextButton = findViewById(R.id.NextImageButton);
    }
}