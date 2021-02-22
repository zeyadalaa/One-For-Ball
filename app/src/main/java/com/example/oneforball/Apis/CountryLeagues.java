package com.example.oneforball.Apis;

import com.example.oneforball.Apis.Pojos.LeaguesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryLeagues implements ApiDataCall{
    private int countryId;

    public CountryLeagues(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public void retriveData(AsynTunneling asynTunneling) {
        ApiManager.getApis()
                .getCountryLeagues(API_KEY , "" + this.countryId)
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
