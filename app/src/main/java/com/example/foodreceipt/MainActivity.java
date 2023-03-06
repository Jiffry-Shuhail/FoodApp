package com.example.foodreceipt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn=findViewById(R.id.signIn);
        signIn.setOnClickListener(v->{
            startActivity(new Intent(this, Home.class));
            finish();
        });
    }
}