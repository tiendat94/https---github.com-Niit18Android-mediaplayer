package com.dh.mediaplayer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dh.mediaplayer.bean.SongBean;
import com.dh.mediaplayer.player_online.PlayMusicOnline;

import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private FragmentTabHost mTabHost;

    public static List<SongBean> lstSong;
    public static PlayMusicOnline playMusic;
    public static int iPosition;

    public TextView  tvMusicSinger;
    public  TextView tvMusicName;
    private ImageButton imbtPlayStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imbtPlayStop = (ImageButton) findViewById(R.id.imbtPlayStop);
        tvMusicSinger = (TextView)findViewById(R.id.tvMusicSinger);
        tvMusicName = (TextView)findViewById(R.id.tvMusicName);

        iPosition = 0;
        playMusic = new PlayMusicOnline(this);
        buildTabHost();
        handlerPlayminibar();
    }

    private void buildTabHost() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("home").setIndicator(this.getTabIndicator(mTabHost.getContext(), R.string.title_tabs_nav_one, R.drawable.img_tabs_home)),
                HomeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("local").setIndicator(this.getTabIndicator(mTabHost.getContext(), R.string.title_tabs_nav_two, R.drawable.img_tabs_local)),
                LocalFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("online").setIndicator(this.getTabIndicator(mTabHost.getContext(), R.string.title_tabs_nav_three, R.drawable.img_tabs_online)),
                OnlineFragment.class, null);
    }

    private void handlerPlayminibar() {
        toolbar = (Toolbar) findViewById(R.id.toolbarMiniPlayer);
        toolbar.setOnClickListener(this);
    }

    private View getTabIndicator(Context context, int title, int img) {
        View view = LayoutInflater.from(context).inflate(R.layout.tabs_navigation, null);
        TextView tv = (TextView) view.findViewById(R.id.txt_tabs_nav);
        ImageView imgv = (ImageView) view.findViewById(R.id.imgv_tabs_nav);

        tv.setText(title);
        imgv.setImageResource(img);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbarMiniPlayer:
                Intent intent = new Intent(MainActivity.this, PlayMusicActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void exitByBackKey() {
        new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }

    public void onPlayPreview(View v) {
        try {
            if (lstSong != null) {
                iPosition = iPosition - 1;
                if (iPosition < 0) {
                    iPosition = lstSong.size() - 1;
                }
                playMusic.playAudio(lstSong.get(iPosition).getLink());
                tvMusicName.setText(lstSong.get(iPosition).getMusicName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPlayStop(View v) {
        try {
            boolean status = playMusic.playStopAudio();

            if (status) {
                imbtPlayStop.setImageResource(R.drawable.btn_pause);
            } else {
                imbtPlayStop.setImageResource(R.drawable.btn_play);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPlayNext(View v) {
        try {
            if (lstSong != null) {
                iPosition = iPosition + 1;
                if (iPosition > lstSong.size() - 1) {
                    iPosition = 0;
                }
                playMusic.playAudio(lstSong.get(iPosition).getLink());
                tvMusicName.setText(lstSong.get(iPosition).getMusicName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
