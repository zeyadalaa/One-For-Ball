package com.example.oneforball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.oneforball.databinding.ActivityLeaguesBinding;

public class LeaguesActivity extends AppCompatActivity {
    ActivityLeaguesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeaguesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}