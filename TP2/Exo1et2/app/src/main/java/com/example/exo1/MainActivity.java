package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.Valider)).
                setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Exo1
                        EditText NomEditText = (EditText)findViewById(R.id.NomEditText);
                        EditText PrenomEditText = (EditText)findViewById(R.id.PrenomEditText);
                        EditText NumeroEditText = (EditText)findViewById(R.id.NumeroEditText);
                        String Nom = NomEditText.getText().toString()+" ";
                        String Prenom = PrenomEditText.getText().toString()+" ";
                        String Numero = NumeroEditText.getText().toString()+" ";
                        ArrayList<String> info = new ArrayList<String>();
                        info.add(Nom+" "+Prenom+" "+Numero);
                        //info.add(Prenom);
                        //info.add(Numero);


                        //Exo2
                        int i = 0;
                        if( getIntent().getExtras() != null)
                        {
                            ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("saved");

                            for(; i<infos.size();i++){
                                info.add(infos.get(i));
                            }
                        }


                        //Exo3
                        String filename = "DataExo3";
                        try {
                            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);

                            try {
                                fos.write(Nom.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                fos.write(Prenom.getBytes());
                                //Toast.makeText(MainActivity.this, "saved to"+getFilesDir()+"/"+filename, Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                fos.write(Numero.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            fos.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        Intent List = new Intent(MainActivity.this,ListActivity.class);
                        List.putStringArrayListExtra("infos",info);
                        Toast.makeText(MainActivity.this,++i+"", Toast.LENGTH_LONG).show();

                        startActivity(List);
                    }
                });
    }
}
