package com.example.oneforball.Apis;

import com.example.oneforball.Apis.Pojos.LeaguesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubscribedLeagues implements ApiDataCall{
    private boolean subscription;

    public SubscribedLeagues(boolean subscription) {
        this.subscription = subscription;
    }

    @Override
    public void retriveData(AsynTunneling asynTunneling) {
        ApiManager.getApis().getSubscribedLeagues(API_KEY , "" + subscription)
                .enqueue(new Callback<LeaguesResponse>() {
                    @Override
                    public void onResponse(Call<LeaguesResponse> call, Response<LeaguesResponse> response) {
                        asynTunneling.receiveData(response.body());
                    }

                    @Override
                    public void onFailure(Call<LeaguesResponse> call, Throwable t) {

                    }
                });
    }
}
