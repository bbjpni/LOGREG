package com.bzsomi.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //dbhelper x = new dbhelper(MainActivity.this);
        //x.onUpgrade(x.getWritableDatabase(),1,1);
    }

    EditText fehasz, jelszo;
    Button reg, bej;
    dbhelper adatbazis;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    private void init(){
        fehasz = findViewById(R.id.NevEmailInput);
        jelszo = findViewById(R.id.JelszoInput);
        reg = findViewById(R.id.LogUpBtn);
        bej = findViewById(R.id.LogInBtn);
        adatbazis = new dbhelper(MainActivity.this);
        sharedPref = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisztracioActivity.class);
                startActivity(i);
            }
        });

        bej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean pass = adatbazis.BejelentkezesNevvel(fehasz.getText().toString(),  jelszo.getText().toString());
                if (!pass)
                {
                    pass = adatbazis.BejelentkezesEmaillal(fehasz.getText().toString(),  jelszo.getText().toString());
                }
                Toast.makeText(getApplicationContext(), pass ? "Sikeres" : "Sikertelen",Toast.LENGTH_SHORT).show();
                if (pass){
                    editor.putString("Nev", fehasz.getText().toString());
                    editor.putString("Jelszo", jelszo.getText().toString());
                    editor.commit();
                    fehasz.setText("");
                    jelszo.setText("");
                    Intent i = new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(i);
                }
                else
                {
                    fehasz.setText("");
                    jelszo.setText("");
                }



            }
        });
    }
}