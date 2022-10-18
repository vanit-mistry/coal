package com.coal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coal.service.CoalService;
import com.coal.util.ReportDetails;

@Controller
@RequestMapping("/coal")
public class CoalController {

	@Autowired
	private CoalService coalService;
	
	@GetMapping("/hello")
	public @ResponseBody String hello()
	{
		return "Hello";
	}
	
	@GetMapping("/getReportDetails")
	public @ResponseBody ReportDetails getReportDetails()
	{
		return coalService.getReportDetails();
	}
}
