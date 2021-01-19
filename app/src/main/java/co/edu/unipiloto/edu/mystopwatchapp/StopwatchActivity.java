package co.edu.unipiloto.edu.mystopwatchapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class StopwatchActivity extends Activity {
    TextView time_view1;
    private int seconds = 0;
    private boolean running;
    private int secondsvuel = 0;
    private int vuelta=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            secondsvuel = savedInstanceState.getInt("secondsvuel");
        }
        runTimer();
    }


    public void onClickVuelta(View view) {
        vuelta++;
        int hours = secondsvuel / 3600;
        int minutes = (secondsvuel % 3600) / 60;
        int secs = secondsvuel % 60;
        String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
        switch (vuelta){
            case 1 :{
                time_view1=(TextView)findViewById(R.id.tiempo1);
                time_view1.setText(time);
                break;
            }
            case 2 :{
                time_view1=(TextView)findViewById(R.id.tiempo2);
                time_view1.setText(time);
                break;
            }
            case 3 :{
                time_view1=(TextView)findViewById(R.id.tiempo3);
                time_view1.setText(time);
                break;
            }
            case 4 :{
                time_view1=(TextView)findViewById(R.id.tiempo4);
                time_view1.setText(time);
                break;
            }
            case 5 :{
                time_view1=(TextView)findViewById(R.id.tiempo5);
                time_view1.setText(time);
                break;
            }
            case 6 :{
                time_view1=(TextView)findViewById(R.id.tiempo6);
                time_view1.setText(time);
                break;
            }
            case 7 :{
                time_view1=(TextView)findViewById(R.id.tiempo7);
                time_view1.setText(time);
                break;
            }
            case 8 :{
                time_view1=(TextView)findViewById(R.id.tiempo8);
                time_view1.setText(time);
                break;
            }
            case 9 :{
                time_view1=(TextView)findViewById(R.id.tiempo9);
                time_view1.setText(time);
                break;
            }
            case 10 :{
                time_view1=(TextView)findViewById(R.id.tiempo10);
                time_view1.setText(time);
                break;
            }
        }

        secondsvuel=0;

    }

    //start button clicked action
    public void onClickStart(View view) {
        running = true;
    }

    //stop button clicked action
    public void onClickStop(View view) {
        running = false;
    }

    //reset button clicked action
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
        secondsvuel=0;
        vuelta=0;
        switch (vuelta){
            case 0 :{
                time_view1=(TextView)findViewById(R.id.tiempo1);
                time_view1.setText("");
            }
            case 2 :{
                time_view1=(TextView)findViewById(R.id.tiempo2);
                time_view1.setText("");
            }
            case 3 :{
                time_view1=(TextView)findViewById(R.id.tiempo3);
                time_view1.setText("");
            }
            case 4 :{
                time_view1=(TextView)findViewById(R.id.tiempo4);
                time_view1.setText("");
            }
            case 5 :{
                time_view1=(TextView)findViewById(R.id.tiempo5);
                time_view1.setText("");
            }
            case 6 :{
                time_view1=(TextView)findViewById(R.id.tiempo6);
                time_view1.setText("");
            }
            case 7 :{
                time_view1=(TextView)findViewById(R.id.tiempo7);
                time_view1.setText("");
            }
            case 8 :{
                time_view1=(TextView)findViewById(R.id.tiempo8);
                time_view1.setText("");
            }
            case 9 :{
                time_view1=(TextView)findViewById(R.id.tiempo9);
                time_view1.setText("");
            }
            case 10 :{
                time_view1=(TextView)findViewById(R.id.tiempo10);
                time_view1.setText("");

            }
        }

    }


    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    secondsvuel++;
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putInt("secondsvuel",secondsvuel);
        savedInstanceState.putBoolean("running", running);
    }

}