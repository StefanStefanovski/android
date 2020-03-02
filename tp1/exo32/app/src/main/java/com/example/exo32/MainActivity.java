package com.example.exo32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLinearLayout = new LinearLayout(this);
        mainLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        mainLinearLayout.setLayoutParams(lp);

        LinearLayout edit = new LinearLayout(this);
        edit.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        edit.setLayoutParams(lp1);
        TextView Nom = new TextView(this);
        Nom.setText("Nom\n");
        //Nom.setTextSize(24);
        TextView Prenom = new TextView(this);
        Prenom.setText("Prenom\n");
        //Prenom.setTextSize(24);
        TextView Age = new TextView(this);
        Age.setText("Age\n");
        //Age.setTextSize(24);
        TextView Competences = new TextView(this);
        Competences.setText("Competences\n");
        //Competences.setTextSize(24);
        TextView Telephone = new TextView(this);
        Telephone.setText("\nTéléphone");
        //Telephone.setTextSize(24);
        edit.addView(Nom);
        edit.addView(Prenom);
        edit.addView(Age);
        edit.addView(Competences);
        edit.addView(Telephone);

        LinearLayout disp = new LinearLayout(this);
        disp.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        disp.setLayoutParams(lp2);
        EditText NomEdit = new EditText(this);
        EditText PrenomEdit = new EditText(this);
        EditText AgeEdit = new EditText(this);
        EditText CompetencesEdit = new EditText(this);
        EditText TelephoneEdit = new EditText(this);

        Button Bouton = new Button(this);
        Bouton.setText("Valider");

        disp.addView(NomEdit);
        disp.addView(PrenomEdit);
        disp.addView(AgeEdit);
        disp.addView(CompetencesEdit);
        disp.addView(TelephoneEdit);
        disp.addView(Bouton);
        mainLinearLayout.addView(edit);
        mainLinearLayout.addView(disp);
        setContentView(mainLinearLayout);

/*
        LinearLayout monLinearLayout = new LinearLayout(this);
        monLinearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView monTextView1 = new TextView(this);
        monTextView1.setText(" Notre premier cours Android");
        TextView monTextView2 = new TextView(this);
        monTextView2.setText(" vivement le premier TP");
        monLinearLayout.addView(monTextView1);
        monLinearLayout.addView(monTextView2);
        setContentView(monLinearLayout);
  */
    }
}
