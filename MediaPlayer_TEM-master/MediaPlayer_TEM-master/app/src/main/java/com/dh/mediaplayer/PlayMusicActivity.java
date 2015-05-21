package com.dh.mediaplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by DH on 4/22/2015.
 */
public class PlayMusicActivity extends Activity implements View.OnClickListener {
    private ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playmusic_layout);

        init();
    }

    private void init() {
        btnBack = (ImageButton)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBack:
                finish();
                overridePendingTransition(R.anim.top_in,R.anim.bottom_out);
                break;
            default:
                break;
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.top_in,R.anim.bottom_out);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
