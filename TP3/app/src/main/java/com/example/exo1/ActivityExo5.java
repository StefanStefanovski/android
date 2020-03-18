package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.exo1.R.drawable.proximity;

public class ActivityExo5 extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo5);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximity==null){
            Toast.makeText(this, "couldnt find proximity sensor",Toast.LENGTH_SHORT);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        if(event.values[0]<=5){
            imageView.setImageResource(R.drawable.proximity);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
