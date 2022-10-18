package com.coal.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.coal.domain.Boundaries;
import com.coal.repository.BoundriesRepository;
import com.coal.util.ReportDetails;


@SpringBootTest
public class BoundriesServiceTest {

	@Mock
	private BoundriesRepository boundriesRepository;

	@InjectMocks
	private BoundriesService boundriesService;

	@Test
	public void getBoundaryPointsTest() {

        // mock
        var boundary1 = new Boundaries("B1", 1, 2);
        var boundary2 = new Boundaries("B1", 4, 2);
        var boundary3 = new Boundaries("B1", 4, 5);
        var boundary4 = new Boundaries("B1", 1, 5);

        List<Boundaries> boundries = Stream.of(boundary1, boundary2, boundary3, boundary4).collect(Collectors.toList());

        when(boundriesRepository.findByType("B1")).thenReturn(boundries);		
		
		ReportDetails boundaryPoints = boundriesService.getBoundaryPoints("B1");
		
		assertThat(1, equalTo(boundaryPoints.getX1()));
		assertThat(4, equalTo(boundaryPoints.getX2()));
		assertThat(2, equalTo(boundaryPoints.getY1()));
		assertThat(5, equalTo(boundaryPoints.getY2()));
	}

}
