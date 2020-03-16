package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSensor();
        Button Exercice3 = (Button)findViewById(R.id.Exo3);
        Exercice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exo3 = new Intent(MainActivity.this,ActivityExo3.class);
                startActivity(exo3);
            }
        });

        Button Exercice4 = (Button)findViewById(R.id.Exo4);
        Exercice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exo4 = new Intent(MainActivity.this,ActivityExo4.class);
                startActivity(exo4);
            }
        });
    }
    private void listSensor(){
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayList<String> sensorDisplay = new ArrayList<>();
        for (Sensor sensor : sensors) {
            sensorDisplay.add("Name: " + sensor.getName() +"" );
        }
        ArrayAdapter<String> display = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sensorDisplay);
        ListView listView = (ListView) findViewById(R.id.listvew);
        listView.setAdapter(display);
        //Exo2
        SensorManager sensorManager2;
        sensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager2.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){

            Toast.makeText(this,"Le sensor magnetic field est present",Toast.LENGTH_LONG).show();
            // Success! There's a magnetometer.
        } else {
            Toast.makeText(this,"magnetic field n'est pas disponible",Toast.LENGTH_LONG).show();
            // Failure! No magnetometer.
        }

    }
}
