package com.coal.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CoalControllerIntegrationTest {

	// bind the above RANDOM_PORT
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getReportDetailsTest() throws MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/coal/getReportDetails?excClaimValue=100").toString(),
				String.class);
		String body = response.getBody();
		assertThat(true, is(body.contains("x1")));
		assertThat(true, is(body.contains("x2")));
		assertThat(true, is(body.contains("y1")));
		assertThat(true, is(body.contains("y2")));
		
		assertThat(true, is(body.contains("mining")));
		assertThat(true, is(body.contains("claim")));
		
		assertThat(HttpStatus.OK, equalTo(response.getStatusCode()));
	}

	@Test
	void getReportDetailsMissingExcClaimValueParameterTest() throws MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/coal/getReportDetails").toString(),
				String.class);

		assertThat("excClaimValue is a mandatory field", equalTo(response.getBody()));
		assertThat(HttpStatus.BAD_REQUEST, equalTo(response.getStatusCode()));
	}

	@Test
	void getReportDetailsInvalidExcClaimValueParameterTest() throws MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/coal/getReportDetails?excClaimValue=100aaa").toString(),
				String.class);

		assertThat("Invalid value, please enter a valid numeric value", equalTo(response.getBody()));
		assertThat(HttpStatus.BAD_REQUEST, equalTo(response.getStatusCode()));
	}
	
}
