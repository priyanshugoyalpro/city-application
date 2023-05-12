package com.sg.citylistapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sg.citylistapp.model.CityRequest;
import com.sg.citylistapp.model.CityResponse;
import com.sg.citylistapp.service.CityListService;

@ExtendWith(MockitoExtension.class)
public class CityListRestAPITest {

	@Mock
	CityListService cityListService;

	@InjectMocks
	CityListRestAPI restApi;

	@Test
	public void getAllCitiesTest() {
		CityResponse city = new CityResponse(1, "Hathras", "www.hts.vom");
		Mockito.when(cityListService.getCities()).thenReturn(Collections.singletonList(city));
		ResponseEntity<List<CityResponse>> result = restApi.getCities();
		assertEquals(city.getName(), result.getBody().get(0).getName());
		assertEquals(city.getUrl(), result.getBody().get(0).getUrl());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void getAllCititNoDataPresentTest() {

		Mockito.when(cityListService.getCities()).thenReturn(Collections.EMPTY_LIST);
		ResponseEntity<List<CityResponse>> result = restApi.getCities();
		assertEquals(0, result.getBody().size());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void getAllCitiesTestCount() {

		Mockito.when(cityListService.getCities()).thenReturn(mockAllCitiesData());
		ResponseEntity<List<CityResponse>> result = restApi.getCities();
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(5, result.getBody().size());
	}

	@Test
	public void getCityByIdTest() {
		Mockito.when(cityListService.getCityById(anyLong()))
				.thenReturn(new CityResponse(1L, "Tallin", "www.talin.com"));
		ResponseEntity<CityResponse> result = restApi.getCityById(1L);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().getId());
	}

	@Test
	public void getCityNameTest() {
		Mockito.when(cityListService.getCityByName(anyString()))
				.thenReturn(Collections.singletonList(new CityResponse(1L, "Tallin", "www.talin.com")));
		ResponseEntity<List<CityResponse>> result = restApi.getCityName("Tallin");
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals("Tallin", result.getBody().get(0).getName());
	}
	
	@Test
	public void getByPageTest() {
		Mockito.when(cityListService.getByPageAndSize(anyInt(), anyInt()))
				.thenReturn((Collections.singletonList(new CityResponse(1L, "Tallin", "www.talin.com"))));
		ResponseEntity<List<CityResponse>> result = restApi.getByPage(1, 6);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals("Tallin", result.getBody().get(0).getName());
	}
	
	@Test
	public void updateTest() {
		Mockito.when(cityListService.update(anyLong(), any()))
				.thenReturn(new CityResponse(1L, "Tartu", "www.talin.com"));
		ResponseEntity<CityResponse> result = restApi.update(1L, new CityRequest( "Tartu", "www.talin.com"));
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals("Tartu", result.getBody().getName());
	}

	private List<CityResponse> mockAllCitiesData() {
		List<CityResponse> cities;
		CityResponse city1 = new CityResponse(1, "Hathras", "www.hts.vom");
		CityResponse city2 = new CityResponse(2, "Amsterdam", "www.amsterdam.vom");
		CityResponse city3 = new CityResponse(3, "Tallin", "www.tallin.vom");
		CityResponse city4 = new CityResponse(4, "Geethroon", "www.geethroon.vom");
		CityResponse city5 = new CityResponse(5, "Paris", "www.paris.vom");
		cities = List.of(city1, city2, city3, city4, city5);
		return cities;
	}
}
