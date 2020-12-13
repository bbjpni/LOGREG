package com.bzsomi.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisztracioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);
        init();
    }

    EditText Cemail, Cfehasz, Cjelszo, Cteljes;
    Button Creg, Cback;

    private void init(){
        Cemail = findViewById(R.id.EmailInput);
        Cfehasz = findViewById(R.id.NevInput);
        Cjelszo = findViewById(R.id.JelszoInput);
        Cteljes = findViewById(R.id.TeljesNevInput);
        Creg = findViewById(R.id.SaveBtn);
        Cback = findViewById(R.id.BackBtn);

        Cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Creg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Cemail.getText().toString().trim().equals("") )
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg e-mailt!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (Cfehasz.getText().toString().trim().equals("") )
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg felhaználónevet!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (Cjelszo.getText().toString().trim().equals("") )
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg jelszót!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (Cteljes.getText().toString().trim().equals("") || Cteljes.getText().toString().trim().split(" ").length < 2)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg teljes nevet!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),Cteljes.getText().toString().trim(),Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}