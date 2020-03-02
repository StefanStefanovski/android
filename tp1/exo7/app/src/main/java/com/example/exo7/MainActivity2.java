package com.example.exo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final TextView text = (TextView)findViewById(R.id.numero);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText(str);
        ((Button) findViewById(R.id.appeler)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:"+text));
                        startActivity(intent);
                    }
                });
    }
}
