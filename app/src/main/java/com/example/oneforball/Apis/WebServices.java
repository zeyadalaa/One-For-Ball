package com.example.oneforball.Apis;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {
      @GET("https://app.sportdataapi.com/api/v1/soccer/countries")
      Call<CountriesResponse> getCountries(@Query("apikey") String apiKey);
}
