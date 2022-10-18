package com.coal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coal.domain.Mining;

@Repository
public interface MiningRepository extends JpaRepository<Mining, Integer> {
	
	@Query(value = "SELECT * FROM MINING m WHERE m.LATITUDE >= :x1 and m.LATITUDE <= :x2 and m.LONGITUDE >= :y1 and m.LONGITUDE <= :y2", nativeQuery = true)
	List<Mining> findMiningByPoints(@Param("x1") int x1, @Param("x2") int x2, @Param("y1") int y1, @Param("y2") int y2);
}
