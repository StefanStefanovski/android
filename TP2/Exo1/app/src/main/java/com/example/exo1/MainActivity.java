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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataHelper myDb = new DataHelper(this);

        ((Button) findViewById(R.id.Valider)).
                setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Exo1
                        EditText NomEditText = (EditText)findViewById(R.id.NomEditText);
                        EditText PrenomEditText = (EditText)findViewById(R.id.PrenomEditText);
                        EditText NumeroEditText = (EditText)findViewById(R.id.NumeroEditText);
                        String Nom = NomEditText.getText().toString();
                        String Prenom = PrenomEditText.getText().toString();
                        String Numero = NumeroEditText.getText().toString();
                        ArrayList<String> info = new ArrayList<String>();
                        info.add(Nom+" "+Prenom+" "+Numero);
                        //info.add(Prenom);
                        //info.add(Numero);

                        int i = 0;

                        //Exo2
                        if( getIntent().getExtras() != null)
                        {
                            ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("saved");

                            for(; i<infos.size();i++){
                                info.add(infos.get(i));
                            }
                        }
                        TextView compteur = (TextView)findViewById(R.id.compteurText);
                        compteur.setText(++i+" :compteur");



                        //Exo3
                        String filename = "fichierExo3";
                        try {
                            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);

                            if( getIntent().getExtras() != null)
                            {
                                ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("saved");

                                for(i=0; i<=infos.size();i++){
                                    fos.write(info.get(i).getBytes());
                                    fos.write("\n".getBytes());
                                }
                            }
                            /*try {
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
                            }*/

                            fos.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }





                        //Exo4
                        boolean isInserted = myDb.insertData(Nom,Prenom,Numero);
                        if(isInserted){
                            Toast.makeText(MainActivity.this, "contact inseré dans la BDD et dans le fichier",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "contact N'EST PAS inseré dans la BDD",Toast.LENGTH_SHORT).show();

                        }
                        Intent List = new Intent(MainActivity.this,ListActivity.class);
                        List.putStringArrayListExtra("infos",info);
                        //Toast.makeText(MainActivity.this,++i+"", Toast.LENGTH_LONG).show();

                        startActivity(List);
                    }
                });


        Button btnfichier = (Button)findViewById(R.id.bouttonFichier);
        btnfichier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ifichier = new Intent(MainActivity.this,contactsFichier.class);
                startActivity(Ifichier);
            }
        });
        Button btnBDD = (Button)findViewById(R.id.boutonBdd);
        btnBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IBDD = new Intent(MainActivity.this,contactsBDD.class);
                startActivity(IBDD);
            }
        });

        Button btnStartService = (Button)findViewById(R.id.boutonStartService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getBaseContext(), MyService.class));
            }
        });
        Button btnStopService = (Button)findViewById(R.id.boutonStopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getBaseContext(),MyService.class));
            }
        });

        ((Button) findViewById(R.id.ajoutFichier)).
                setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Exo1
                        EditText NomEditText = (EditText)findViewById(R.id.NomEditText);
                        EditText PrenomEditText = (EditText)findViewById(R.id.PrenomEditText);
                        EditText NumeroEditText = (EditText)findViewById(R.id.NumeroEditText);
                        String Nom = NomEditText.getText().toString();
                        String Prenom = PrenomEditText.getText().toString();
                        String Numero = NumeroEditText.getText().toString();
                        ArrayList<String> info = new ArrayList<String>();
                        info.add(Nom+" "+Prenom+" "+Numero);
                        //info.add(Prenom);
                        //info.add(Numero);

                        int i = 0;

                        //Exo2
                        if( getIntent().getExtras() != null)
                        {
                            ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("saved");

                            for(; i<infos.size();i++){
                                info.add(infos.get(i));
                            }
                        }
                        TextView compteur = (TextView)findViewById(R.id.compteurText);
                        compteur.setText(++i+" :compteur");



                        //Exo3
                        String filename = "fichierExo3";
                        try {
                            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);

                            if( getIntent().getExtras() != null)
                            {
                                ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("saved");

                                for(i=0; i<=infos.size();i++){
                                    fos.write(info.get(i).getBytes());
                                    fos.write("\n".getBytes());
                                }
                            }
                            /*try {
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
                            }*/

                            fos.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Intent List = new Intent(MainActivity.this,ListActivity.class);
                        List.putStringArrayListExtra("infos",info);
                        //Toast.makeText(MainActivity.this,++i+"", Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "contact inseré dans le fichier, compteur: "+i+"",Toast.LENGTH_SHORT).show();

                        startActivity(List);
                    }
                });
        ((Button) findViewById(R.id.ajoutBdd)).
                setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Exo1
                        EditText NomEditText = (EditText)findViewById(R.id.NomEditText);
                        EditText PrenomEditText = (EditText)findViewById(R.id.PrenomEditText);
                        EditText NumeroEditText = (EditText)findViewById(R.id.NumeroEditText);
                        String Nom = NomEditText.getText().toString();
                        String Prenom = PrenomEditText.getText().toString();
                        String Numero = NumeroEditText.getText().toString();
                        ArrayList<String> info = new ArrayList<String>();
                        info.add(Nom+" "+Prenom+" "+Numero);
                        //info.add(Prenom);
                        //info.add(Numero);

                        int i = 0;

                        //Exo2
                        if( getIntent().getExtras() != null)
                        {
                            ArrayList<String> infos = (ArrayList<String>) getIntent().getSerializableExtra("saved");

                            for(; i<infos.size();i++){
                                info.add(infos.get(i));
                            }
                        }
                        TextView compteur = (TextView)findViewById(R.id.compteurText);
                        compteur.setText(++i+" :compteur");

                        //Exo4
                        boolean isInserted = myDb.insertData(Nom,Prenom,Numero);
                        if(isInserted){
                            Toast.makeText(MainActivity.this, "contact inseré dans la BDD, compteur: "+i+"",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "contact N'EST PAS inseré dans la BDD",Toast.LENGTH_SHORT).show();

                        }
                        Intent List = new Intent(MainActivity.this,ListActivity.class);
                        List.putStringArrayListExtra("infos",info);
                       // Toast.makeText(MainActivity.this,++i+"", Toast.LENGTH_LONG).show();

                        startActivity(List);
                    }
                });
        }
    }