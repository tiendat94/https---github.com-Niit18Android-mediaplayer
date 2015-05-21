package com.dh.mediaplayer.player_online;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;

import java.io.IOException;

/**
 * Created by DH on 5/15/2015.
 * Chung nhim
 */
public class PlayMusicOnline implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {
    private MediaPlayer mediaPlayer;
    private FragmentActivity fragmentActivity;
    Context context;

    public PlayMusicOnline(Context mContext) {
        context = mContext;
    }

    public void playAudio(String url) {
        killMediaPlayer();

        try {
            if (mediaPlayer == null) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            }
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  boolean playStopAudio(){
        boolean status = false;
        try {
           if (mediaPlayer.isPlaying())
           {
               mediaPlayer.pause();
               status= true;
           }
            else
           {
               mediaPlayer.start();
               status = false;
           }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return status;
    }

    private void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
//        songProgressBar.setSecondaryProgress(percent);
//
//        if(percent==100)
//        {
//            Progressbar.setVisibility(View.INVISIBLE);
//
//        }else if(percent > songProgressBar.getProgress())
//        {
//            Progressbar.setVisibility(View.INVISIBLE);
//        }else
//        {
//            Progressbar.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

//        //mediaPlayer.reset();
//        songProgressBar.setProgress(0);
//        songProgressBar.setSecondaryProgress(0);
//        play.setVisibility(View.VISIBLE);
//        stop.setVisibility(View.GONE);
//        link = "http://server11.mp3quran.net/hawashi/002.mp3";
//        playMp3(link);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            //Progressbar.setVisibility(View.INVISIBLE);
            //play.setVisibility(View.GONE);
            //stop.setVisibility(View.VISIBLE);
            //songProgressBar.setProgress(0);
            //songProgressBar.setMax(100);
        }
        //updateProgressBar();
    }
}
