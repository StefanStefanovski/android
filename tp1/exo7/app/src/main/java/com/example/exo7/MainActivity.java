package com.example.exo7;

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
        final EditText Telephone = (EditText)findViewById(R.id.TelephoneEditText);

        ((Button) findViewById(R.id.Bouton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        String str = Telephone.getText().toString();
                        intent.putExtra("message", str);
                        startActivity(intent);
                    }
                });
    }
}
