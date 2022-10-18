package com.coal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOUNDRIES")
public class Boundaries {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
	private int axisX;
	private int axisY;

	public Boundaries() {
	}
	
	public Boundaries(String type, int x, int y) {
		this.type = type;
		this.axisX = x;
		this.axisY = y;
	}

	public String getType() {
		return type;
	}

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}
	
}
