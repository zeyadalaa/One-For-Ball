package com.example.oneforball.Apis.Pojos;

import com.google.gson.annotations.SerializedName;

public class CountryItem {

	@SerializedName("continent")
	private String continent;

	@SerializedName("country_code")
	private Object countryCode;

	@SerializedName("name")
	private String name;

	@SerializedName("country_id")
	private int countryId;

	public void setContinent(String continent){
		this.continent = continent;
	}

	public String getContinent(){
		return continent;
	}

	public void setCountryCode(Object countryCode){
		this.countryCode = countryCode;
	}

	public Object getCountryCode(){
		return countryCode;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCountryId(int countryId){
		this.countryId = countryId;
	}

	public int getCountryId(){
		return countryId;
	}
}