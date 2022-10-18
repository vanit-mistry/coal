package com.coal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coal.domain.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer>{
}
