package com.coal.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import com.coal.domain.Boundaries;

public class ReportDetailsTest {

	@Test
	public void setPoints() {
		ReportDetails boundaryPoints = new ReportDetails();
		Boundaries boundary1 = new Boundaries("B1", 1, 2);
		Boundaries boundary2 = new Boundaries("B1", 4, 2);
		Boundaries boundary3 = new Boundaries("B1", 4, 5);
		Boundaries boundary4 = new Boundaries("B1", 1, 5);
		
		boundaryPoints.setPoints(boundary1);
		boundaryPoints.setPoints(boundary2);
		boundaryPoints.setPoints(boundary3);
		boundaryPoints.setPoints(boundary4);
		
		assertThat(1, equalTo(boundaryPoints.getX1()));
		assertThat(4, equalTo(boundaryPoints.getX2()));
		assertThat(2, equalTo(boundaryPoints.getY1()));
		assertThat(5, equalTo(boundaryPoints.getY2()));
	}
	
}
