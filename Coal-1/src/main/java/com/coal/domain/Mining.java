package com.coal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MINING")
public class Mining {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer latitude;
	private Integer longitude;
	private Integer depth;
	
	public Mining() {
	}
	
	public Mining(Integer latitude, Integer longitude, Integer depth) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.depth = depth;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public Integer getDepth() {
		return depth;
	}
	
}
