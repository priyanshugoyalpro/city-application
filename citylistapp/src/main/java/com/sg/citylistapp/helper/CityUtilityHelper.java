package com.sg.citylistapp.helper;

import com.sg.citylistapp.entity.City;
import com.sg.citylistapp.model.CityResponse;

/**
 * Utility Class
 * 
 * @author priyanshu.goyal
 *
 */
public class CityUtilityHelper {

	public static CityResponse convertCityToResponse(City city) {

		return new CityResponse(city.getId(), city.getName(), city.getUrl());
	}

}
