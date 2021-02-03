package com.example.oneforball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent mInHome = new Intent(Splash_Screen_Activity.this, InvoiceASAPTabActivity.class);
                Splash_Screen_Activity.this.startActivity(mInHome);
                Splash_Screen_Activity.this.finish();
            }
        }, 6000);
    }
}