package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityExo3 extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo3);



        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if ( accelerometer != null){
            
            //Toast.makeText(this,"Le sensor accelerometer est present",Toast.LENGTH_LONG).show();
            sensorManager.registerListener(ActivityExo3.this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
            // Success! There's a magnetometer.
        } else {
            Toast.makeText(this,"accelerometer n'est pas disponible",Toast.LENGTH_LONG).show();
            // Failure! No magnetometer.
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        TextView xValue = (TextView)findViewById(R.id.xText);
        TextView yValue = (TextView)findViewById(R.id.yText);
        TextView zValue = (TextView)findViewById(R.id.zText);
        xValue.setText("x: "+event.values[0]);
        yValue.setText("y: "+event.values[1]);
        zValue.setText("z: "+event.values[2]);


        if(event.values[0]<=0){
            xValue.setTextColor(0xff00ff00);
        }else if(event.values[0]>0 && event.values[0]<10){
            xValue.setTextColor(0xff000000);
        }else if (event.values[0]>=10){
            xValue.setTextColor(0xffff0000);
        }
        if(event.values[1]<=0){
            yValue.setTextColor(0xff00ff00);
        }else if(event.values[1]>0 && event.values[1]<10){
            yValue.setTextColor(0xff000000);
        }else if (event.values[1]>=10){
            yValue.setTextColor(0xffff0000);
        }
        if(event.values[2]<=0){
            zValue.setTextColor(0xff00ff00);
        }else if(event.values[2]>0 && event.values[2]<10){
            zValue.setTextColor(0xff000000);
        }else if (event.values[2]>=10){
            zValue.setTextColor(0xffff0000);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
