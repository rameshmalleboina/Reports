package com.web1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web1.entity.Eligibility_dtls;

public interface Eligiblerepo extends JpaRepository<Eligibility_dtls, Integer>{

	
	@Query("select distinct (plan_name) from Eligibility_dtls")
	public List<String> findPlanName();
  
	@Query("select distinct (plan_status) from Eligibility_dtls")
	public List<String> findPlanStatus();
  


}
