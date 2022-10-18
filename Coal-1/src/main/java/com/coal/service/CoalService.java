package com.coal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coal.repository.MiningRepository;
import com.coal.util.ReportDetails;

@Component
public class CoalService {

	@Autowired
	private MiningRepository miningRepository;

	@Autowired
	private BoundriesService boundriesService;
	
	public ReportDetails getReportDetails() {
		ReportDetails reportDetails = boundriesService.getBoundaryPoints("B1");
		reportDetails.setMining(miningRepository.findMiningByPoints(reportDetails.getX1(), reportDetails.getX2(), reportDetails.getY1(), reportDetails.getY2()));
		
		return reportDetails;
	}
	
}
