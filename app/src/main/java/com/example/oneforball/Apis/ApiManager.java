package com.example.oneforball.Apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private ApiManager(){}
    private static Retrofit retrofit;
    private static Retrofit getInstance(){
        if(retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://app.sportdataapi.com/api/v1/soccer/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
    public static WebServices getApis(){
        return getInstance().create(WebServices.class);
    }
}
