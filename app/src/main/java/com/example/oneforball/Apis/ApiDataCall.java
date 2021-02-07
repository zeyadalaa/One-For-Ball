package com.example.oneforball.Apis;

import java.util.List;

public interface ApiDataCall<Type>{
     String API_KEY = "9fdebf00-66cd-11eb-85f9-2fe309e59279";
     Type retriveData(AsynTunneling asynTunneling);
}
