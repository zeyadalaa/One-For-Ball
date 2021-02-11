package com.example.oneforball.Apis.Pojos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LeaguesResponse {

	@SerializedName("data")
	private List<LeagueItem> data;

	public List<LeagueItem> getData(){
		return data;
	}
}