package com.eynav.hackathonr2r;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btn_1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_1 =findViewById(R.id.btn_1);

        btn_1.setOnClickListener(l->{
            Intent intent = new Intent(MainActivity2.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}