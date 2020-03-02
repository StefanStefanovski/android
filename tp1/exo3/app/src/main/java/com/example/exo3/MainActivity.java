package com.example.exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.Bouton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Confirmer", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "Annuler", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}


