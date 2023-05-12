package com.sg.citylistapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request DTO for updating city details
 * @author priyanshu.goyal
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityRequest {

	private String name;
	private String url;

}
