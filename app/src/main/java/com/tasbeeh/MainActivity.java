package com.tasbeeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import com.ramijemli.percentagechartview.PercentageChartView;


public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private int count_tasbeeh = 0;
    private int max = 33;
    private int time_vibrate = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        PercentageChartView chartView = findViewById(R.id.bar);
        chartView.setProgress(count, true);

        TextView txt_count = findViewById(R.id.txt_count);
        txt_count.setText("" + count);


        findViewById(R.id.img_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_tasbeeh == max) {
                    count_tasbeeh = 0;
                    time_vibrate = 10;
                } else if(count_tasbeeh == max -1) {
                    time_vibrate = 1000;
                }
                count++;
                count_tasbeeh++;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    final VibrationEffect effect = VibrationEffect.createOneShot(time_vibrate,
                            VibrationEffect.EFFECT_TICK);
                    vibrator.cancel();
                    vibrator.vibrate(effect);
                }

                txt_count.setText("" + count);
                chartView.setProgress((count_tasbeeh / (float) max) * 100, true);
            }
        });

        findViewById(R.id.img_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count > 0) {
                    count--;
                    time_vibrate = 10;
                    if(count % max == 0) {
                        if(count != 0) {
                            count_tasbeeh = max;
                        } else {
                            count_tasbeeh = 0;
                        }
                    } else {
                        count_tasbeeh--;
                    }

//                    count_tasbeeh = (count % max == 0) ? (count != 0) ? max : 0 : count_tasbeeh--;

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        final VibrationEffect effect = VibrationEffect.createOneShot(time_vibrate,
                                VibrationEffect.EFFECT_TICK);
                        vibrator.cancel();
                        vibrator.vibrate(effect);
                    }

                    txt_count.setText("" + count);
                    chartView.setProgress((count_tasbeeh / (float) max) * 100, true);
                }
            }
        });

        findViewById(R.id.img_reload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                count_tasbeeh = 0;
                time_vibrate = 10;
                txt_count.setText("" + count);
                chartView.setProgress((count_tasbeeh / (float) max) * 100, true);
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}