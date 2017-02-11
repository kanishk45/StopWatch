package com.example.kanishk.stopwatch;

import android.os.Handler;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int milliseconds=0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }
public void onClickStart(View view){
running=true;
}
public void onClickStop(View view){

    running=false;
}
public void onClickReset(View view){
    running=false;
    milliseconds=0;
}
private void runTimer(){
    final TextView timeView=(TextView) findViewById(R.id.time_view);
    final Handler handler= new Handler();
    handler.post(new Runnable() {
        @Override
        public void run() {
            int minutes=milliseconds/3600;
            int secs=(milliseconds%3600)/60;
            int milli=milliseconds%60;

            String time= String.format("%d:%02d:%02d", minutes,secs,milli);
            timeView.setText(time);
            if(running){

                milliseconds++;
            }
            handler.postDelayed(this, 10);
        }
    });


}
}
