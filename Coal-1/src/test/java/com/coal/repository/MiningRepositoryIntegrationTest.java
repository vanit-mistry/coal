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
	public void findDepthsByPointsTest() {
		
		// given
		entityManager.persist(new Mining(4, 3, 120));
		entityManager.persist(new Mining(7, 9, 80));
		entityManager.persist(new Mining(9, 3, 90));
		entityManager.persist(new Mining(2, 2, 250));
		entityManager.persist(new Mining(8, 5, 50));

		entityManager.flush();

		// when
		List<Mining> minings = miningRepository.findMiningByPoints(1, 4, 2, 5);

		// then
		assertThat(2, equalTo(minings.size()));
		
		minings.stream().forEach(m -> {
			assertThat(true, is(m.getLatitude() >= 1 && m.getLatitude() <= 4));
			assertThat(true, is(m.getLongitude() >= 2 && m.getLongitude() <= 5));
		});
	}

}
