package com.bzsomi.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisztracioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);
        init();
    }

    EditText Cfehasz, Cjelszo, Cemail, Cteljes;
    Button Creg, Cback;

    private void init(){
        Cemail = findViewById(R.id.EmailInput);
        Cfehasz = findViewById(R.id.NevInput);
        Cjelszo = findViewById(R.id.JelszoInput);
        Cteljes = findViewById(R.id.TeljesNevInput);
        Creg = findViewById(R.id.LogUpBtn);
        Cback = findViewById(R.id.BackBtn);

        Cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}