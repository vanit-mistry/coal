package com.coal.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.coal.domain.Boundaries;

@DataJpaTest
public class BoundriesRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BoundriesRepository boundriesRepository;

	@Test
	public void findTypeExistTest() {

		// given
		entityManager.persist(new Boundaries("B1", 1, 2));
		entityManager.persist(new Boundaries("B1", 4, 2));
		entityManager.persist(new Boundaries("B1", 4, 5));
		entityManager.persist(new Boundaries("B1", 1, 5));

		entityManager.persist(new Boundaries("B2", 8, 2));
		entityManager.persist(new Boundaries("B2", 9, 2));
		entityManager.persist(new Boundaries("B2", 9, 3));
		entityManager.persist(new Boundaries("B2", 8, 3));

		entityManager.flush();

		// when
		List<Boundaries> boundries = boundriesRepository.findByType("B1");

		// then
		assertThat(4, equalTo(boundries.size()));

		// when
		boundries = boundriesRepository.findByType("B2");

		// then
		assertThat(4, equalTo(boundries.size()));

		// when
		boundries = boundriesRepository.findByType("B3");

		// then
		assertThat(0, equalTo(boundries.size()));

	}

}
