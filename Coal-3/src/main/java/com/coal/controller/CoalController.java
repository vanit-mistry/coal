package com.coal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.coal.service.CoalService;
import com.coal.util.ReportDetails;

@Controller
@RequestMapping("/coal")
public class CoalController {

	@Autowired
	private CoalService coalService;

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello";
	}

	@GetMapping("/getReportDetails")
	@ResponseBody
	public List<ReportDetails> getReportDetails(@RequestParam(required = true) int excClaimValue) {
		return coalService.getReportDetails(excClaimValue);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleItemNotFoundException() {
		return "excClaimValue is a mandatory field";
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleItemBindException() {
		return "Invalid value, please enter a valid numeric value";
	}

}
