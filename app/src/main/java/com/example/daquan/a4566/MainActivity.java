package com.example.daquan.a4566;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends Activity {
    private SeekBar green;
    private MySeekBar read,blue;
    private TextView pan,textView;
    private int colorNum;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        green = (SeekBar) findViewById(R.id.green);
        read = (MySeekBar) findViewById(R.id.read);
        blue = (MySeekBar) findViewById(R.id.blue);
        pan = (TextView) findViewById(R.id.pan);
        textView = (TextView)findViewById(R.id.textView);
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                colorNum = Color.rgb(read.getProgress(),i,blue.getProgress());
                pan.setBackgroundColor(colorNum);
                int red = (colorNum & 0xff0000) >> 16;
                int green = (colorNum & 0x00ff00) >> 8;
                int blue = (colorNum & 0x0000ff);
                String stringColor = String.format("%02X%02X%02X",red,green,blue);
                textView.setText(stringColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        read.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                colorNum = Color.rgb(i,green.getProgress(),blue.getProgress());
                pan.setBackgroundColor(colorNum);
                int red = (colorNum & 0xff0000) >> 16;
                int green = (colorNum & 0x00ff00) >> 8;
                int blue = (colorNum & 0x0000ff);
                String stringColor = String.format("%02X%02X%02X",red,green,blue);
                textView.setText(stringColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                colorNum = Color.rgb(read.getProgress(),green.getProgress(),i);
                pan.setBackgroundColor(colorNum);
                int red = (colorNum & 0xff0000) >> 16;
                int green = (colorNum & 0x00ff00) >> 8;
                int blue = (colorNum & 0x0000ff);
                String stringColor = String.format("%02X%02X%02X",red,green,blue);
                textView.setText(stringColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}