package com.coal.util;

import java.util.List;

import com.coal.domain.Boundaries;
import com.coal.domain.Claim;
import com.coal.domain.Mining;

public class ReportDetails {

	private int x1 = 2147483647;
	private int x2;
	private int y1 = 2147483647;
	private int y2;
	private List<Mining> mining;
	private List<Claim> claim;

	public ReportDetails() {
		super();
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public void setPoints(Boundaries boundaries) {
		if (boundaries.getAxisX() < x1) {
			x1 = boundaries.getAxisX();
		}

		if (boundaries.getAxisX() > x2) {
			x2 = boundaries.getAxisX();
		}

		if (boundaries.getAxisY() < y1) {
			y1 = boundaries.getAxisY();
		}

		if (boundaries.getAxisY() > y2) {
			y2 = boundaries.getAxisY();
		}

	}

	public List<Mining> getMining() {
		return mining;
	}

	public void setMining(List<Mining> mining) {
		this.mining = mining;
	}

	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}

}
