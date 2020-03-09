package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class contactsBDD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_b_d_d);

        final ArrayList<String> infos = new ArrayList<String>();
        DataHelper db = new DataHelper(this);
        Cursor cursor = db.alldata();
        if(cursor.getCount()==0){
            Toast.makeText(this, "Pas de données disponible", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                String Nom = cursor.getString(1);
                String Prenom = cursor.getString(2);
                String Numero = cursor.getString(3);
                infos.add(Nom+" "+Prenom+" "+Numero);
            }
        }
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infos);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(list);


        ((Button)findViewById(R.id.saisir)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent List = new Intent(contactsBDD.this,MainActivity.class);
                List.putStringArrayListExtra("saved",infos);
                startActivity(List);
            }
        });
    }
}
