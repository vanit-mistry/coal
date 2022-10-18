package com.coal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coal.domain.Boundaries;
import com.coal.repository.BoundriesRepository;
import com.coal.util.ReportDetails;

@Component
public class BoundriesService {

	@Autowired
	private BoundriesRepository boundriesRepository;
	
	public ReportDetails getBoundaryPoints(String type) {
		List<Boundaries> boundries =  boundriesRepository.findByType(type);
		
		// Set min max coordinate points
		ReportDetails boundaryPoints = new ReportDetails();
		boundries.forEach(b -> {
			boundaryPoints.setPoints(b);
		});
		
		return boundaryPoints;
	}
}
