package com.sg.citylistapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.citylistapp.entity.City;

/**
 * @author priyanshu.goyal
 *
 */
@Repository
public interface CityListRepository extends JpaRepository<City, Long> {

	/**
	 * This method find the city with the given parameter
	 * @param name is the name of the City
	 * @return City Object is returned from the database
	 */

	public List<City> findByNameContainingIgnoreCase(String name);

}
