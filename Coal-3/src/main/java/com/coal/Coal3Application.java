package com.coal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.coal.domain.Boundaries;
import com.coal.domain.Claim;
import com.coal.domain.Mining;
import com.coal.repository.BoundriesRepository;
import com.coal.repository.ClaimRepository;
import com.coal.repository.MiningRepository;

@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class Coal3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Coal3Application.class, args);
		init(context);
	}

	public static void init(ConfigurableApplicationContext context) {
		initMining(context);
		initClaim(context);
		initBoundries(context);
		System.out.println("DB initailiation complete");
	}

	private static void initMining(ConfigurableApplicationContext context) {
		MiningRepository miningRepository = context.getBean(MiningRepository.class);
		miningRepository.save(new Mining(4, 3, 120));
		miningRepository.save(new Mining(7, 9, 80));
		miningRepository.save(new Mining(9, 3, 90));
		miningRepository.save(new Mining(2, 2, 250));
		miningRepository.save(new Mining(8, 5, 50));
	}

	public static void initClaim(ConfigurableApplicationContext context) {
		ClaimRepository claimRepository = context.getBean(ClaimRepository.class);
		claimRepository.save(new Claim(2, 5, 10000));
		claimRepository.save(new Claim(4, 4, 30000));
		claimRepository.save(new Claim(1, 4, 500));
	}
	
	private static void initBoundries(ConfigurableApplicationContext context) {
		BoundriesRepository boundriesRepository = context.getBean(BoundriesRepository.class);
		boundriesRepository.save(new Boundaries("B1", 1, 2));
		boundriesRepository.save(new Boundaries("B1", 4, 2));
		boundriesRepository.save(new Boundaries("B1", 4, 5));
		boundriesRepository.save(new Boundaries("B1", 1, 5));
		
		boundriesRepository.save(new Boundaries("B2", 8, 2));
		boundriesRepository.save(new Boundaries("B2", 9, 2));
		boundriesRepository.save(new Boundaries("B2", 9, 3));
		boundriesRepository.save(new Boundaries("B2", 8, 3));
	}

}
