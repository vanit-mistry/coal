package com.coal.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.coal.domain.Mining;

@DataJpaTest
public class MiningRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MiningRepository miningRepository;

	@Test
	public void findDepthsByB1PointsTest() {
		
		// given
		entityManager.persist(new Mining(4, 3, 120));
		entityManager.persist(new Mining(7, 9, 80));
		entityManager.persist(new Mining(9, 3, 90));
		entityManager.persist(new Mining(2, 2, 250));
		entityManager.persist(new Mining(8, 5, 50));

		entityManager.flush();


		int x1 = 1;
		int x2 = 4;
		int y1 = 2;
		int y2 = 5;
		
		// when
		List<Mining> depths = miningRepository.findDepthsByPoints(x1, x2, y1, y2);

		// then
		assertThat(2, equalTo(depths.size()));
		
		depths.stream().forEach(d -> {
			assertThat(true, is(d.getLatitude() >= x1 && d.getLatitude() <= x2));
			assertThat(true, is(d.getLongitude() >= y1 && d.getLongitude() <= y2));
		});
	}

	@Test
	public void findDepthsByB2PointsTest() {
		
		// given
		entityManager.persist(new Mining(4, 3, 120));
		entityManager.persist(new Mining(7, 9, 80));
		entityManager.persist(new Mining(9, 3, 90));
		entityManager.persist(new Mining(2, 2, 250));
		entityManager.persist(new Mining(8, 5, 50));

		entityManager.flush();

		int x1 = 8;
		int x2 = 9;
		int y1 = 2;
		int y2 = 3;
		
		// when
		List<Mining> depths = miningRepository.findDepthsByPoints(x1, x2, y1, y2);

		// then
		assertThat(1, equalTo(depths.size()));
		
		depths.stream().forEach(d -> {
			assertThat(true, is(d.getLatitude() >= x1 && d.getLatitude() <= x2));
			assertThat(true, is(d.getLongitude() >= y1 && d.getLongitude() <= y2));
		});
	}

}
