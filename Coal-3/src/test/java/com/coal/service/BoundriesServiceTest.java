package com.coal.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
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

	private final static String BOUNDARY_1 = "B1";
	private final static String BOUNDARY_2 = "B2";
	
	@Mock
	private BoundriesRepository boundriesRepository;

	@InjectMocks
	private BoundriesService boundriesService;

	@Test
	public void getBoundaryPointsB1Test() {

        // mock
        var boundary1 = new Boundaries(BOUNDARY_1, 1, 2);
        var boundary2 = new Boundaries(BOUNDARY_1, 4, 2);
        var boundary3 = new Boundaries(BOUNDARY_1, 4, 5);
        var boundary4 = new Boundaries(BOUNDARY_1, 1, 5);

        List<Boundaries> boundries = Stream.of(boundary1, boundary2, boundary3, boundary4).collect(Collectors.toList());

        when(boundriesRepository.findByType(BOUNDARY_1)).thenReturn(boundries);		
		
		ReportDetails boundaryPoints = boundriesService.getBoundaryPoints(BOUNDARY_1);
		
		assertThat(1, equalTo(boundaryPoints.getX1()));
		assertThat(4, equalTo(boundaryPoints.getX2()));
		assertThat(2, equalTo(boundaryPoints.getY1()));
		assertThat(5, equalTo(boundaryPoints.getY2()));
	}

	@Test
	public void getBoundaryPointsB2Test() {

        // mock
        var boundary1 = new Boundaries(BOUNDARY_2, 8, 2);
        var boundary2 = new Boundaries(BOUNDARY_2, 9, 2);
        var boundary3 = new Boundaries(BOUNDARY_2, 9, 3);
        var boundary4 = new Boundaries(BOUNDARY_2, 8, 3);

        List<Boundaries> boundries = Stream.of(boundary1, boundary2, boundary3, boundary4).collect(Collectors.toList());

        when(boundriesRepository.findByType(BOUNDARY_2)).thenReturn(boundries);		
		
		ReportDetails boundaryPoints = boundriesService.getBoundaryPoints(BOUNDARY_2);
		
		assertThat(8, equalTo(boundaryPoints.getX1()));
		assertThat(9, equalTo(boundaryPoints.getX2()));
		assertThat(2, equalTo(boundaryPoints.getY1()));
		assertThat(3, equalTo(boundaryPoints.getY2()));
	}	
}
