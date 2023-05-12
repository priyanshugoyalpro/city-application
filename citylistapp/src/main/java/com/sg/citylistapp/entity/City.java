package com.sg.citylistapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author priyanshu.goyal This Entity represents the City table
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "city")
public class City {

	@Id
	public long id;

	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "url", length = 1000)
	private String url;

}
