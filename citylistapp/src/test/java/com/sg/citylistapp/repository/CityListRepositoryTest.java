package com.sg.citylistapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import com.sg.citylistapp.entity.City;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CityListRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	CityListRepository cityListRepository;

	@Test
	public void newCTest() {
		City city = new City(1L, "Hathras", "hjgjgjg");
		City result = cityListRepository.save(city);
		City existingUser = entityManager.find(City.class, result.getId());
		assertThat(existingUser.getName()).isEqualTo(city.getName());
	}
}
