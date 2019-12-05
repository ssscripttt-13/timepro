package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSeconds(0);
    }
    public void onClickStart (View view) {
        timer.start();
        Button b = (Button)view;
        b.setEnabled(false);

    }
    public void onClickStop (View view) {
        timer.cancel();
        Button buttonf = (Button) findViewById(R.id.buttons);
        buttonf.setEnabled(true);
    }
    public void onClickReset (View view) {
        timer.cancel();
        Button buttonr = (Button) findViewById(R.id.buttons);
        buttonr.setEnabled(true);
        setSeconds(0);
    }
    public void setSeconds(int value) {
        this.seconds = value;
        updateTimeView();
    }
    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, 1000) {
        public void onTick(long millisUntilFinished) {
            setSeconds(++seconds);
        }
        public void onFinish() {
        }
    };
    public void updateTimeView() {
        int ss = seconds % 60;
        int minutes = seconds / 60;
        int mm = minutes % 60;
        int hours = minutes / 60;
        String timeString = String.format("%02d:%02d:%02d", hours, mm, ss);
        TextView timeView = (TextView) findViewById(R.id.time);
        timeView.setText(timeString);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
