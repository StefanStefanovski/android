package com.example.exo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Nom = (EditText)findViewById(R.id.NomEditText);
        EditText Prenom = (EditText)findViewById(R.id.PrenomEditText);
        EditText Age = (EditText)findViewById(R.id.AgeEditText);
        EditText Competences = (EditText) findViewById(R.id.CompetencesEditText);
        EditText Telephone = (EditText)findViewById(R.id.TelephoneEditText);

        /*ArrayList<String> info = new ArrayList();
        info.add(Nom+"");
        info.add(Prenom+"");
        info.add(Age+"");
        info.add(Competences+"");
        info.add(Telephone+"");
        final ArrayList<String> infos = info;
*/
       // Bundle b = new Bundle();
        //b.putStringArrayList("info",info);
        //Intent i=new Intent(context, Class);
        //i.putExtras(b);


        ((Button) findViewById(R.id.Bouton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        //intent.putExtra("infos",infos);
                        startActivity(intent);
                    }
                });
    }
}
