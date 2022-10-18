package com.coal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coal.domain.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	@Query(value = "SELECT * FROM CLAIM c WHERE c.LATITUDE >= :x1 and c.LATITUDE <= :x2 and c.LONGITUDE >= :y1 and c.LONGITUDE <= :y2", nativeQuery = true)
	List<Claim> findClaimByPoints(@Param("x1") int x1, @Param("x2") int x2, @Param("y1") int y1, @Param("y2") int y2);
}
