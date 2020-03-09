package com.example.exo1;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyService extends Service {
    public MyService() {
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        ArrayList<String> infos = new ArrayList<String>();
        String filename = "fichierExo3";
        try {
            FileInputStream fis = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text=br.readLine())!=null) {

                sb.append(text).append("\n");
            }
            String al[] = sb.toString().split("\n");
            /*for(int i = 0; i<al.length;i++){
                infos.add(al[i]);
                //Toast.makeText(ListActivity.this,al[i],Toast.LENGTH_SHORT).show();
            }*/
            DataHelper db = new DataHelper(this);

            for(int i = 0;i<al.length;i++){
                String contact[] = al[i].split(" ");
                Cursor cursor;

                if(db.getNom(contact[0]).getCount()==0){
                    //Toast.makeText(this,"insert: "+contact.toString(),Toast.LENGTH_SHORT);
                    db.insertData(contact[0],contact[1],contact[2]);

                }else if(db.getPreNom(contact[1]).getCount()==0){
                    //Toast.makeText(this,"insert: "+contact.toString(),Toast.LENGTH_SHORT);

                    db.insertData(contact[0],contact[1],contact[2]);

                }else if(db.getNumero(contact[2]).getCount()==0){
                    //Toast.makeText(this,"insert: "+contact.toString(),Toast.LENGTH_SHORT);

                    db.insertData(contact[0],contact[1],contact[2]);
                }
                //Toast.makeText(this,"insert: "+contact.toString(),Toast.LENGTH_SHORT);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
