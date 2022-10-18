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

	public List<ReportDetails> getReportDetails(int excClaimValue) {
		List<ReportDetails> reportDetails = new ArrayList<>();
		reportDetails.add(getReportDetail("B1", excClaimValue));
		reportDetails.add(getReportDetail("B2", excClaimValue));
		
		return reportDetails;
	}
	
	private ReportDetails getReportDetail(String type, int excClaimValue) {
		ReportDetails reportDetail = boundriesService.getBoundaryPoints(type);
		reportDetail.setMining(miningRepository.findDepthsByPoints(reportDetail.getX1(), reportDetail.getX2(), reportDetail.getY1(), reportDetail.getY2()));
		reportDetail.setClaim(claimRepository.findClaimByPoints(reportDetail.getX1(), reportDetail.getX2(), reportDetail.getY1(), reportDetail.getY2(), excClaimValue));
		
		return reportDetail;
	}
	
}
