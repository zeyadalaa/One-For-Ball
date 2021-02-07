package com.example.oneforball.Apis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Countries implements ApiDataCall{

    @Override
    public CountriesResponse retriveData(AsynTunneling asynTunneling) {
        ApiManager.getApis().getCountries(API_KEY).enqueue(new Callback<CountriesResponse>() {
            @Override
            public void onResponse(Call<CountriesResponse> call, Response<CountriesResponse> response) {
                asynTunneling.receiveData(response.body());
            }

            @Override
            public void onFailure(Call<CountriesResponse> call, Throwable t) {
            }
        });
        return null;
    }
}
