package com.sg.citylistapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.sg.citylistapp.entity.City;
import com.sg.citylistapp.model.CityRequest;
import com.sg.citylistapp.model.CityResponse;
import com.sg.citylistapp.repository.CityListRepository;

@ExtendWith(MockitoExtension.class)
public class CityListServiceTest {

	@Mock
	private CityListRepository repository;

	@InjectMocks
	private CityListService service;

	@Test
	public void getCityListTest() {
		City city = new City(1, "Hathras", "www.hts.vom");
		Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(city));
		List<CityResponse> result = service.getCities();
		assertEquals(city.getName(), result.get(0).getName());
		assertEquals(city.getUrl(), result.get(0).getUrl());
	}

	@Test
	public void getCityByIdTest() {
		City city = new City(11, "Hathras", "www.hts.vom");
		Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(city));
		CityResponse result = service.getCityById(11L);
		assertEquals(11L, result.getId());
		assertEquals("Hathras", result.getName());
	}

	@Test
	public void getCityListBYNameTest() {
		City city = new City(11, "Hathras", "www.hts.vom");
		Mockito.when(repository.findByNameContainingIgnoreCase(anyString()))
				.thenReturn(Collections.singletonList(city));
		List<CityResponse> result = service.getCityByName("HATHRAS");
		assertEquals(11L, result.get(0).getId());
		assertEquals("Hathras", result.get(0).getName());
	}
	
	@Test
	public void getByPageAndSizeTest() {
		City city = new City(11, "Hathras", "www.hts.vom");
		Mockito.when(repository.findAll(any(PageRequest.class)))
				.thenReturn(new PageImpl<>(List.of(city)));
		List<CityResponse> result = service.getByPageAndSize(1,5);
		assertEquals(11L, result.get(0).getId());
		assertEquals("Hathras", result.get(0).getName());
	}

	@Test
	public void getCityListBuyWhenCityNotFound() {
		Mockito.when(repository.findByNameContainingIgnoreCase(anyString())).thenReturn(Collections.EMPTY_LIST);
		List<CityResponse> result = service.getCityByName("HATHRAS");
		assertEquals(0, result.size());
	}
	
	@Test
	public void update() {
		City city = new City(11, "Hathras", "www.hts.vom");
		CityRequest updated = new CityRequest("My Other City", "www.hts.vom");

		// When
		Mockito.when(repository.findById(any(Long.class))).thenReturn(Optional.ofNullable(city));
		Mockito.when(repository.save(any(City.class))).thenReturn(city);

		// Then
		CityResponse updatedFromService = service.update(1L, updated);
		assertEquals(updated.getName(), updatedFromService.getName());
		assertEquals(updated.getUrl(), updatedFromService.getUrl());

	}	

}
