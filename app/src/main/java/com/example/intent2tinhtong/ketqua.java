package com.example.intent2tinhtong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ketqua extends AppCompatActivity {
    EditText edtkq;
    Button btnback;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketqua);

        edtkq = findViewById(R.id.txtkq);
        btnback = findViewById(R.id.btnback);

        Intent yourIntent = getIntent();
        Bundle yourBundle = yourIntent.getBundleExtra("mybackage");

        int a = yourBundle.getInt("soa");
        int b = yourBundle.getInt("sob");
        String kq = "";

        if (a == 0 && b == 0) {
            kq = "Vô số nghiệm";
        } else if (a == 0 && b != 0) {
            kq = "Vô nghiệm";
        } else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = dcf.format(-b * 1.0 / a);
        }

        edtkq.setText(kq);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
