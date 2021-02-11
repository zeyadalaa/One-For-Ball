package com.example.oneforball.Apis.Pojos;

import com.google.gson.annotations.SerializedName;

public class LeagueItem {

	@SerializedName("name")
	private String name;

	@SerializedName("league_id")
	private int leagueId;

	@SerializedName("country_id")
	private int countryId;

	public String getName(){
		return name;
	}

	public int getLeagueId(){
		return leagueId;
	}

	public int getCountryId(){
		return countryId;
	}
}