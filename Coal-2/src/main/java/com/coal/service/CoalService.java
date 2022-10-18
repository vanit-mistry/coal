package com.coal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coal.repository.ClaimRepository;
import com.coal.repository.MiningRepository;
import com.coal.util.ReportDetails;

@Component
public class CoalService {

	@Autowired
	private MiningRepository miningRepository;

	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private BoundriesService boundriesService;

	public List<ReportDetails> getReportDetails() {
		List<ReportDetails> reportDetails = new ArrayList<>();
		reportDetails.add(getReportDetail("B1"));
		reportDetails.add(getReportDetail("B2"));
		
		return reportDetails;
	}
	
	private ReportDetails getReportDetail(String type) {
		ReportDetails reportDetail = boundriesService.getBoundaryPoints(type);
		reportDetail.setMining(miningRepository.findMiningByPoints(reportDetail.getX1(), reportDetail.getX2(), reportDetail.getY1(), reportDetail.getY2()));
		reportDetail.setClaim(claimRepository.findClaimByPoints(reportDetail.getX1(), reportDetail.getX2(), reportDetail.getY1(), reportDetail.getY2()));
		
		return reportDetail;
	}
	
}
