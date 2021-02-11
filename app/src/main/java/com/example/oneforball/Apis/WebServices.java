package com.example.oneforball.Apis;

import com.example.oneforball.Apis.Pojos.CountriesResponse;
import com.example.oneforball.Apis.Pojos.LeaguesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {
      @GET("countries")
      Call<CountriesResponse> getCountries(@Query("apikey") String apiKey);
      @GET("leagues")
      Call<LeaguesResponse> getCountryLeagues(@Query("apikey") String apiKey ,
                                              @Query("country_id") String countryId);
      @GET("leagues")
      Call<LeaguesResponse> getSubscribedLeagues(@Query("apikey") String apiKey ,
                                                 @Query("subscribed") String subscription);
}
