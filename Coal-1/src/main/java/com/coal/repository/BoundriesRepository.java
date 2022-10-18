package com.coal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coal.domain.Boundaries;

@Repository
public interface BoundriesRepository extends JpaRepository<Boundaries, Integer>{

	List<Boundaries> findByType(String type);
}
