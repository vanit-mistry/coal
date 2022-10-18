package com.coal.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.coal.domain.Claim;

@DataJpaTest
public class ClaimRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ClaimRepository claimRepository;

	@Test
	public void finClaimB1Test() {
		// given
		entityManager.persist(new Claim(2, 5, 10000));
		entityManager.persist(new Claim(4, 4, 30000));
		entityManager.persist(new Claim(1, 4, 500));
		entityManager.flush();
		
		// when
		List<Claim> claims = claimRepository.findClaimByPoints(1, 4, 2, 5, 9999999);

		// then
		assertThat(3, equalTo(claims.size()));

		claims.stream().forEach(c -> {
			assertThat(true, is(c.getLatitude() >= 1 && c.getLatitude() <= 4));
			assertThat(true, is(c.getLongitude() >= 2 && c.getLongitude() <= 5));
		});
	}

	@Test
	public void finClaimB2Test() {
		// given
		entityManager.persist(new Claim(2, 5, 10000));
		entityManager.persist(new Claim(4, 4, 30000));
		entityManager.persist(new Claim(1, 4, 500));
		entityManager.flush();
		
		// when
		List<Claim> claims = claimRepository.findClaimByPoints(8, 9, 2, 3, 400);

		// then
		assertThat(0, equalTo(claims.size()));
	}
}
