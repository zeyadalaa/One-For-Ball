package com.example.oneforball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.oneforball.Apis.ApiDataCall;
import com.example.oneforball.Apis.AsynTunneling;
import com.example.oneforball.Apis.Countries;
import com.example.oneforball.Apis.CountriesResponse;
import com.example.oneforball.databinding.ActivityLeaguesBinding;

public class LeaguesActivity extends AppCompatActivity implements AsynTunneling<CountriesResponse> {
    private ApiDataCall countriesDataCall;
    private CountriesResponse countriesResponse;
    ActivityLeaguesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeaguesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init(){
        countriesDataCall = new Countries();
        countriesDataCall.retriveData(this);
    }

    @Override
    public void receiveData(CountriesResponse data) {
        countriesResponse = data;

    }
}