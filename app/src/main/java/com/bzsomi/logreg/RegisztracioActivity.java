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
    dbhelper adatbazis;

    private void init(){
        Cemail = findViewById(R.id.EmailInput);
        Cfehasz = findViewById(R.id.NevInput);
        Cjelszo = findViewById(R.id.JelszoInput);
        Cteljes = findViewById(R.id.TeljesNevInput);
        Creg = findViewById(R.id.SaveBtn);
        Cback = findViewById(R.id.BackBtn);

        adatbazis = new dbhelper(RegisztracioActivity.this);

        Cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Creg.setOnClickListener(new View.OnClickListener() {
            @Override
            // ELLENORZES //
            public void onClick(View v) {
                if (Cemail.getText().toString().trim().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"Nem adtál meg e-mailt!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (Cfehasz.getText().toString().trim().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"Nem adtál meg felhaználónevet!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (Cfehasz.getText().toString().trim().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"Nem adtál meg felhaználónevet!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (Cjelszo.getText().toString().trim().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"Nem adtál meg jelszót!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (Cteljes.getText().toString().trim().equals("") || Cteljes.getText().toString().trim().split(" ").length < 2)
                {
                    Toast.makeText(getApplicationContext(),"Nem adtál meg teljes nevet!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!adatbazis.emailEllenorzes(Cemail.getText().toString().trim()))
                {
                    Toast.makeText(getApplicationContext(),"Az email cím már rögzítésre került",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!adatbazis.nevEllenorzes(Cfehasz.getText().toString().trim()))
                {
                    Toast.makeText(getApplicationContext(),"A felhasználónév már rögzítésre került",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    adatbazis.adatRogzites(
                            Cfehasz.getText().toString().trim(),
                            Cteljes.getText().toString().trim(),
                            Cemail.getText().toString().trim(),
                            Cjelszo.getText().toString().trim());
                            Cfehasz.setText("");
                            Cteljes.setText("");
                            Cemail.setText("");
                            Cjelszo.setText("");
                    Toast.makeText(getApplicationContext(),"A felhasználó létrehozva!",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}