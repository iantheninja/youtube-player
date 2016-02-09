package com.iantheninja.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
        implements View.OnClickListener{
    private String GOOGLE_API_KEY = "AIzaSyDf8ajLEnRJeNpc0LgvaT6iFdsQyphWLq8";
    private String YOUTUBE_VIDEO_ID = "_ALeswWzpBo";
    private String YOUTUBE_PLAYLIST = "PL55713C70BA91BD6E";
    private Button playVideo;
    private Button playPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        playVideo = (Button) findViewById(R.id.btnPlayVideo);
        playPlaylist = (Button) findViewById(R.id.btnPlayList);

        //onclick listeners for both buttons
        playVideo.setOnClickListener(this);
        playPlaylist.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        //switches depending on the button pressed
        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if(intent != null){
            startActivity(intent);
        }

    }
}
