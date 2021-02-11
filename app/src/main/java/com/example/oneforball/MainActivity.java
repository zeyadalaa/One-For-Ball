package com.example.oneforball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.oneforball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int leagueId = getIntent().getIntExtra("leagueId" , -1);
        Toast.makeText(this, "League Id : " + leagueId, Toast.LENGTH_SHORT).show();
    }
}