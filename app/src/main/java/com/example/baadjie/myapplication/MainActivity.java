package com.example.baadjie.myapplication;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button startButton;
    private Button pauseButton;
    private TextView timerValue;
    private long startTime = 0L;
    private Handler customerHandler = new Handler();

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updateTime = 0L;
    private  TextView tv,tv2;
    int count = 0;
    int count2 = 0;
    private Button btnSave;
    private TextView hme,awy;
    private EditText edtTeam1;
    private  EditText getEdtTeam2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerValue = (TextView) findViewById(R.id.timerValue);
        startButton = (Button) findViewById(R.id.button);
        pauseButton = (Button) findViewById(R.id.pauseButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = SystemClock.uptimeMillis();
                customerHandler.postDelayed(updateThread,0);
                //


            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                timeSwapBuff+=timeInMilliseconds;
                customerHandler.removeCallbacks(updateThread);

            }
        });


    }

    private Runnable updateThread = new Runnable() {
        @Override
        public void run() {




            timeInMilliseconds=SystemClock.uptimeMillis()-startTime;
            updateTime=timeSwapBuff + timeInMilliseconds;

            int secs= (int) (updateTime/250);

            int mins=secs/60;

            secs=secs % 60;
            int millseconds= (int) (updateTime % 100);

            timerValue.setText(" " +mins + ":"    + String .format(" %03d",millseconds));

            customerHandler.postDelayed(this,0);








        }

    };

    public void add(View view) {


        count = count + 1;
        display(count);

    }
    public void display(int no) {


        tv = (TextView) findViewById(R.id.textView2);
        tv.setText("" + no);
    }

    public void sub(View view) {


        count = count - 1;
        display(count);


    }
    public void add2(View view) {

        count2=count2+1;
        display2(count2);
    }
    public void display2(int no2){


        tv2= (TextView) findViewById(R.id.textView3);
        tv2.setText(""+no2);
    }
    public void sub2(View view){

        count2=count2-1;
        display2(count2);


    }

}