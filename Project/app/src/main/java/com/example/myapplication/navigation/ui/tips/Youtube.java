package com.example.myapplication.navigation.ui.tips;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Youtube extends YouTubeBaseActivity {

    private final String API_KEY = "AIzaSyDKvm1QoYS-lVzQR8FNVanorB-mDL8xnKg";
    private final String VIDEO_CODE = "sZZsBedy0CU";
    YouTubePlayerView player;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        player = (YouTubePlayerView) findViewById((R.id.player));
        player.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {

            //this method involves YouTube API internal functions

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                // if initialization success, the video will be loaded

                if(!b) {
                    youTubePlayer.loadVideo(VIDEO_CODE);
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                // if the video initialization fail, the toast will notice user

                Toast.makeText(Youtube.this, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}