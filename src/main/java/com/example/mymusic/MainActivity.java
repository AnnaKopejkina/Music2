package com.example.mymusic;

import static android.media.MediaPlayer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView playP ;
 MediaPlayer mediaPlayer;

    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playP = findViewById(R.id.imageViewplay);
        mediaPlayer = new mediaPlayer();
        seekBar = findViewById(R.id.seekBar)


        try {

            AssetFileDescriptor descriptor = getAssets().openFd("shny.mp3");
            mediaPlayer.setDataSource(descriptor.getFileDescriptor().descriptor.getStartOffsed().descriptor.geLength());
            descriptor.close();

            seekBar.setMax(mediaPlayer.getDuration());
            MediaPlayer.prepare();
        }
             catch(IDException e) {
          Log.e("error","файл не найден");
                 mediaPlayer.start();

                 new SeekBarThread (mediaPlayer, seekBar). start();
        }

        playP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
    }

//увеличение и уменьшение громкости
    public boolean onKeyDown(int keyCode, KeyEvent event ) {
        super. onKeyDown(keyCode, event);

        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP ){
             System.out.println("нажата кнопка увеличения звука" );
             mediaPlayer.setVolume(0.5f, 0.5f);

        }

        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN ){
            System.out.println("нажата кнопка уменьшения звука" );
            mediaPlayer.setVolume(-0.5f, -0,5f);
            return true;
        }
return false;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanget (SeekBar seekBar, int i, boolean b) {


            }

            @Override
            public void onStartTrakingTouch(SeekBar seekBar ) {


            }

            @Override
            public void  onStopTrakingTouch(SeekBar seekBar {

            }
        })
        });


    }


/*(event -> {
        System.out.println("включилась музыка");

        MediaPlayer = android.media.MediaPlayer.create(this, R.raw.shny);
        MediaPlayer.start();
    });




