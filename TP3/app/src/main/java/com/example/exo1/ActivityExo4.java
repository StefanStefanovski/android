package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityExo4 extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo4);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if ( accelerometer != null){

            //Toast.makeText(this,"Le sensor accelerometer est present",Toast.LENGTH_LONG).show();
            sensorManager.registerListener(ActivityExo4.this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
            // Success! There's a magnetometer.
        } else {
            Toast.makeText(this,"accelerometer n'est pas disponible",Toast.LENGTH_LONG).show();
            // Failure! No magnetometer.
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float history[];
        history = new float[2];
        float xChange = history[0] - event.values[0];
        float yChange = history[1] - event.values[1];

        history[0] = event.values[0];
        history[1] = event.values[1];
        TextView xValue = (TextView)findViewById(R.id.xText);
        TextView yValue = (TextView)findViewById(R.id.yText);

        if (xChange >0){
            xValue.setText("x: LEFT");
            //direction[0] = "LEFT";
        }
        else if (xChange < 0){
            xValue.setText("x: RIGHT");
            //direction[0] = "RIGHT";
        }

        if (yChange > 10){
            yValue.setText("y: DOWN");
            //direction[1] = "DOWN";
        }
        else if (yChange < 10){
            yValue.setText("y: UP");
            //direction[1] = "UP";
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
