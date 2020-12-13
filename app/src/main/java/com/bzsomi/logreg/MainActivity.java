package com.bzsomi.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        dbhelper x = new dbhelper(MainActivity.this);
        x.onUpgrade(x.getWritableDatabase(),1,1);
    }

    EditText fehasz, jelszo;
    Button reg, bej;
    dbhelper adatbazis;

    private void init(){
        fehasz = findViewById(R.id.NevEmailInput);
        jelszo = findViewById(R.id.JelszoInput);
        reg = findViewById(R.id.LogUpBtn);
        bej = findViewById(R.id.LogInBtn);
        adatbazis = new dbhelper(MainActivity.this);

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
                Toast.makeText(getApplicationContext(),adatbazis.Bejelentkezes(fehasz.getText().toString(),  jelszo.getText().toString()) ?
                        "Sikeres" : "Sikertelen",Toast.LENGTH_SHORT).show();
            }
        });
    }
}