package com.coal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLAIM")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer latitude;
	private Integer longitude;
	private Integer claimValue;
	
	public Claim() {
		
	}
			
	public Claim(Integer latitude, Integer longitude, Integer claimValue) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.claimValue = claimValue;
	}

	public Integer getId() {
		return id;
	}

	public Integer getLatitude() {
		return latitude;
	}
	
	public Integer getLongitude() {
		return longitude;
	}

	public Integer getClaimValue() {
		return claimValue;
	}
	
}
