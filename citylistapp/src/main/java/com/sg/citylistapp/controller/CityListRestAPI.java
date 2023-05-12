package com.sg.citylistapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sg.citylistapp.model.CityRequest;
import com.sg.citylistapp.model.CityResponse;
import com.sg.citylistapp.service.CityListService;

import lombok.RequiredArgsConstructor;

/**
 * This is the Rest Controller class for fetching all the list of Cities
 * 
 * @author priyanshu.goyal
 *
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CityListRestAPI {

	@Autowired
	private CityListService cityListService;
	
	private static final Logger logger = LoggerFactory.getLogger(CityListRestAPI.class);

	/**
	 * This operation returns all the list of cities in the repository
	 * 
	 * @return List<CityResponse>
	 */
	@GetMapping("/cities")
	public ResponseEntity<List<CityResponse>> getCities() {
		logger.info("getting list of all cities");
		List<CityResponse> cities = cityListService.getCities();
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}

	/**
	 * This operations return city on the basis of Id else throw City Not Found
	 * Exception.
	 * 
	 * @param id
	 * @return CityResponse
	 */
	@GetMapping("/cities/{id}")
	public ResponseEntity<CityResponse> getCityById(@PathVariable("id") Long id) {
		logger.info("getting city on the basis of id : ", id);
		CityResponse city = cityListService.getCityById(id);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	/**
	 * This operations return List of cities on the basis of containing name with
	 * ignore case
	 * 
	 * @param name
	 * @return List<CityResponse>
	 */
	@GetMapping("/cities/name/{name}")
	public ResponseEntity<List<CityResponse>> getCityName(@PathVariable("name") String name) {
		logger.info("getting city on the basis of name : ", name);
		List<CityResponse> city = cityListService.getCityByName(name);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	/**
	 * This operations return List of cities on the basis of page and size
	 * 
	 * @param page
	 * @param size
	 * @return List<CityResponse>
	 */
	@GetMapping("/cities/page/{page}/{size}")
	public ResponseEntity<List<CityResponse>> getByPage(@PathVariable("page") int page,
			@PathVariable("size") int size) {
		logger.info("getting city list on the basis of page");
		List<CityResponse> cities = cityListService.getByPageAndSize(page, size);
		return new ResponseEntity<>(cities, HttpStatus.OK);

	}

	/**
	 * 
	 * This operations update the city details on the basis of Id.
	 * 
	 * @param id
	 * @param city
	 * @return CityResponse
	 */
	@PatchMapping("/new/{id}")
	public ResponseEntity<CityResponse> update(@PathVariable("id") Long id, @RequestBody CityRequest city) {
		logger.info("updating city on the basis of id :", id);
		CityResponse cityRes = cityListService.update(id, city);
		return new ResponseEntity<>(cityRes, HttpStatus.OK);
	}
}
