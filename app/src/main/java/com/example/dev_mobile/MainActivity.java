package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    ImageButton btnPlay, btnStop, btnPause;
    TextView textViewTime;
    Handler handler;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.seminovos);

        btnStop = findViewById(R.id.btnStop);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        textViewTime = findViewById(R.id.textViewTime);

        btnStop.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);

        handler = new Handler();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                if (!isPlaying) {
                    mediaPlayer.start();
                    isPlaying = true;
                    updateTextViewTime();
                }
                break;
            case R.id.btnStop:
                if (isPlaying) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    isPlaying = false;
                    textViewTime.setText("00:00");
                    handler.removeCallbacksAndMessages(null);
                }
                break;
            case R.id.btnPause:
                if (isPlaying) {
                    mediaPlayer.pause();
                    isPlaying = false;
                    handler.removeCallbacksAndMessages(null);
                }
                break;
        }
    }

    private void updateTextViewTime() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer.isPlaying()) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    textViewTime.setText(convertDurationMillis(currentPosition));
                    updateTextViewTime();
                }
            }
        }, 1000);
    }
    public String convertDurationMillis(Integer getDurationInMillis){

        int getDurationMillis = getDurationInMillis;
        String convertHours = String.format("%02d", TimeUnit.MILLISECONDS.toHours(getDurationMillis));
        String convertMinutes = String.format("%02d", TimeUnit.MILLISECONDS.toMinutes(getDurationMillis));
        String convertSeconds = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(getDurationMillis) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(getDurationMillis)));

//        String getDuration = convertHours + ":" + convertMinutes + ":" + convertSeconds;
        String getDuration = convertMinutes + ":" + convertSeconds;

        return getDuration;
    }
}