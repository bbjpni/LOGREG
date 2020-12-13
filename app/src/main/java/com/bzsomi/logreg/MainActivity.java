package com.bzsomi.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    EditText fehasz, jelszo;
    Button reg, bej;

    private void init(){
        fehasz = findViewById(R.id.NevEmailInput);
        jelszo = findViewById(R.id.JelszoInput);
        reg = findViewById(R.id.LogUpBtn);
        bej = findViewById(R.id.LogInBtn);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisztracioActivity.class);
                startActivity(i);
            }
        });
    }
}