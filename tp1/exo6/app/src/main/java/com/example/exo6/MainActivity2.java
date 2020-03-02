package com.example.exo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       //Bundle b = this.getIntent().getExtras();
      /* Intent intent = this.getIntent();
        String[] array=intent.getStringArrayExtra("infos");
        TextView disp = new TextView(this);
        /*disp.setText(array+"");
        setContentView(disp);
*/
        /*LinearLayout monLinearLayout = new LinearLayout(this);
        monLinearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView Nom = new TextView(this);
        Nom.setText(array[0]);
        TextView Prenom = new TextView(this);
        Prenom.setText(array[1]);
        TextView Age = new TextView(this);
        Age.setText(array[2]);
        monLinearLayout.addView(Nom);
        monLinearLayout.addView(Prenom);
        monLinearLayout.addView(Age);
        setContentView(monLinearLayout);
        /*for (int i = 1; i< array.length; i++){
            disp.setText(array[i]);
            setContentView(disp);
        }*/
        ((Button) findViewById(R.id.OK)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(intent);
                    }
                });
        ((Button) findViewById(R.id.Retour)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }
                });


    }
}
