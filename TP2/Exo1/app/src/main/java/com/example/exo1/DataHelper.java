package com.example.exo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public static final String baseName = "testdb";

    public static final String tableName = "Contacts";

    public static final String ID = "Id";
    public static final String Nom = "Nom";
    public static final String Prenom = "Prenom";
    public static final String Numero = "Numero";

    public DataHelper(@Nullable Context context) {
        super(context,baseName, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + tableName +
                " ( " +ID + " integer primary key autoincrement, "
                +Nom+" text, "
                +Prenom+" text, "
                +Numero+" text);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+tableName+";");
        onCreate(db);
    }
    public boolean insertData(String nom,String prenom, String numero){
        SQLiteDatabase db = this.getWritableDatabase();
        //onUpgrade(db,1,2);
        ContentValues contentValues = new ContentValues();
        //contentValues.put(ID,1);
        contentValues.put(Nom,nom);
        contentValues.put(Prenom,prenom);
        contentValues.put(Numero,numero);
        long result = db.insert(tableName,null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getNom(String nom){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select Nom from Contacts where Nom="+"'"+nom+"';",null);
        return cursor;
    }
    public Cursor getPreNom(String Prenom){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select Prenom from Contacts where Prenom="+"'"+Prenom+"';",null);
        return cursor;
    }
    public Cursor getNumero(String numero){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select Numero from Contacts where Numero="+"'"+numero+"';",null);
        return cursor;
    }

    public Cursor alldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Contacts;",null);
        return cursor;
    }
}
