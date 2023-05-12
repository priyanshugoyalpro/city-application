package com.sg.citylistapp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.sg.citylistapp.entity.City;
import com.sg.citylistapp.exception.CityNotFoundException;
import com.sg.citylistapp.helper.CityUtilityHelper;
import com.sg.citylistapp.model.CityRequest;
import com.sg.citylistapp.model.CityResponse;
import com.sg.citylistapp.repository.CityListRepository;

/**
 * Contains all the business logic for City List App
 * 
 * @author priyanshu.goyal
 *
 */
@Service
public class CityListService {

	@Autowired
	private CityListRepository cityListRepository;

	/**
	 * This methods returns the list of all cities.
	 * 
	 * @return List<City>
	 */
	public List<CityResponse> getCities() {
		List<City> cities = cityListRepository.findAll();

		return cities.stream().map(x -> {

			return CityUtilityHelper.convertCityToResponse(x);
		}).collect(Collectors.toList());

	}

	/**
	 * This methods returns the city on the basis of id.
	 * 
	 * @param id
	 * @return City
	 */
	public CityResponse getCityById(Long id) {

		City city = cityListRepository.findById(id).orElseThrow(() -> new CityNotFoundException(1, "City Not Found"));
		return CityUtilityHelper.convertCityToResponse(city);
	}

	/**
	 * This methods returns the list of all cities on basis of paginations.
	 * 
	 * @param page
	 * @param size
	 * @return List<City>
	 */
	public List<CityResponse> getByPageAndSize(int page, int size) {
		PageRequest pageSearch = PageRequest.of(page, size);
		List<City> cities = cityListRepository.findAll(pageSearch).toList();
		return cities.stream().map(x -> {

			return CityUtilityHelper.convertCityToResponse(x);
		}).collect(Collectors.toList());

	}

	/**
	 * This methods returns list of the cities on the basis of name.
	 * 
	 * @param name
	 * @return List<City>
	 */
	public List<CityResponse> getCityByName(String name) {
		List<City> cities = cityListRepository.findByNameContainingIgnoreCase(name);
		return cities.stream().map(x -> {

			return CityUtilityHelper.convertCityToResponse(x);
		}).collect(Collectors.toList());

	}

	/**
	 * This method is used to update the details of city on the basis of id
	 * 
	 * @param id
	 * @param city
	 */
	public CityResponse update(Long id, CityRequest city) {
		City data = cityListRepository.findById(id).orElseThrow(() -> new CityNotFoundException(1, "City Not Found"));
		if (Objects.nonNull(city.getName()) && !data.getName().equals(city.getName())) {
			data.setName(city.getName());

		}
		if (Objects.nonNull(city.getUrl()) && !data.getUrl().equals(city.getUrl())) {
			data.setUrl(city.getUrl());
		}
		cityListRepository.save(data);
		return CityUtilityHelper.convertCityToResponse(data);
	}
}
