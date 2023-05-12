package com.sg.citylistapp.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.sg.citylistapp.entity.City;
import com.sg.citylistapp.repository.CityListRepository;

/**
 * This Component class loads the data from csv in In memory database
 * 
 * @author priyanshu.goyal
 *
 */
@Component
public class CityDatabaseLoader {

	Logger logger = LoggerFactory.getLogger(CityDatabaseLoader.class);
	private final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

	private CityListRepository loader;
	ResourceLoader resourceLoader;

	public CityDatabaseLoader(ResourceLoader resourceLoader, CityListRepository loader) {
		this.resourceLoader = resourceLoader;
		this.loader = loader;
	}

	@PostConstruct
	public void loadDataFromCSV() throws IOException {
		logger.info("Reading data from the csv and loading into databases");
		Resource resource = resourceLoader.getResource("classpath:static/cities.csv");

		if (resource.exists()) {
			try {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(resource.getInputStream(), CHARSET_UTF8));

				Stream<String> st = reader.lines();
				List<City> data = st.skip(1).map((line) -> {
					String[] arr = line.split(",");
					return new City(Long.parseLong(arr[0]), arr[1], arr[2]);

				}).toList();
				loader.saveAll(data);
				logger.info("Citeis data are loaded ");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			logger.info("Cities are loaded from static file.");
		} else {
			logger.info("Could not find City Data.");
		}

	}
}