package com.example.exo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    //Exo2
    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedIsntanceState) {
        super.onSaveInstanceState(savedIsntanceState);
        ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("infos");

        savedIsntanceState.putStringArrayList("saved",infos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("infos");

      if((savedInstanceState != null)&& savedInstanceState.containsKey("saved")) {
          ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infos);
          ArrayList<String> list1 = savedInstanceState.getStringArrayList("saved");

          ListView listView = (ListView) findViewById(R.id.listview);
          listView.setAdapter(list);

      }
        else {
           ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infos);
           ListView listView = (ListView) findViewById(R.id.listview);
           listView.setAdapter(list);
       }


      //Exo3
        /*String filename = "DataExo3";
                try {
                    FileInputStream fis = openFileInput(filename);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String text;
                    while((text=br.readLine())!=null){
                        sb.append(text).append("\n");
                    }
                    String al[] = sb.toString().split(" ");
                    ArrayList<String> infos = new ArrayList<String>();
                    /*for(int i = 0; i<al.length;i++){
                        //infos.add(al[i]);
                        //Toast.makeText(ListActivity.this,al[i],Toast.LENGTH_SHORT).show();
                    }
                    infos.add(sb.toString());
                    ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infos);
                    ListView listView = (ListView) findViewById(R.id.listview);
                    listView.setAdapter(list);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
        //Exo1
        ((Button)findViewById(R.id.saisir)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent List = new Intent(ListActivity.this,MainActivity.class);
                 List.putStringArrayListExtra("saved",infos);
                startActivity(List);
            }
        });



    }
}
