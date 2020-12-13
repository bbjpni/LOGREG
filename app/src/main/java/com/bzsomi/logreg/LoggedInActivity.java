package com.bzsomi.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();
        kiir();
    }

    TextView DP;
    Button btn;
    SharedPreferences sharedPref;
    dbhelper adatbazis;

    private void init() {
        sharedPref = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        DP = findViewById(R.id.Display);
        btn = findViewById(R.id.LogOutBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        adatbazis = new dbhelper(LoggedInActivity.this);
    }

    private  void kiir(){
        String[] adatok = new String[] {sharedPref.getString("Nev",""), sharedPref.getString("Jelszo","")};
        String nev = adatbazis.teljesNev(adatok[0], adatok[1]);
        DP.setText("Üdvözöljük, " + nev);
    }
}