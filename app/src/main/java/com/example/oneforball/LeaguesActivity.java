package com.example.oneforball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oneforball.Adapters.LeaguesRecyclerViewAdapter;
import com.example.oneforball.Apis.ApiDataCall;
import com.example.oneforball.Apis.AsynTunneling;
import com.example.oneforball.Apis.Pojos.LeaguesResponse;
import com.example.oneforball.Apis.SubscribedLeagues;
import com.example.oneforball.databinding.ActivityLeaguesBinding;

public class LeaguesActivity extends AppCompatActivity implements AsynTunneling<LeaguesResponse>, LeaguesRecyclerViewAdapter.OnClickLeagueItemListener {
    private ApiDataCall subscribedLeaguesDataCall;
    private final boolean SUBSCRIBED_STATE = true;
    private LeaguesResponse leaguse;

    private LeaguesRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ActivityLeaguesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeaguesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        subscribedLeaguesDataCall.retriveData(this);
    }

    private void init() {
        subscribedLeaguesDataCall = new SubscribedLeagues(SUBSCRIBED_STATE);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new LeaguesRecyclerViewAdapter(null
                , getLayoutInflater(), this);
        binding.leaguesRecyclerView.setLayoutManager(layoutManager);
        binding.leaguesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void receiveData(LeaguesResponse data) {
        leaguse = data;
        adapter.updateData(leaguse.getData());
    }

    @Override
    public void onClickLeagueItem(int leagueId) {
        Intent intent = new Intent(LeaguesActivity.this, MainActivity.class);
        intent.putExtra("leagueId", leagueId);
        startActivity(intent);
    }
}