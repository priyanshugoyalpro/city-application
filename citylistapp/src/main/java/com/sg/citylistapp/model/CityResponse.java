package com.sg.citylistapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response DTO for Rest API
 * @author priyanshu.goyal
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {

	private long id;
	private String name;
	private String url;

}
