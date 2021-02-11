package com.example.oneforball.Apis.Pojos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CountriesResponse {

	@SerializedName("data")
	private List<CountryItem> countryItems;

	public void setCountryItems(List<CountryItem> countryItems){
		this.countryItems = countryItems;
	}

	public List<CountryItem> getCountryItems(){
		return countryItems;
	}
}