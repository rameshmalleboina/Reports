package com.web1.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.web1.entity.Eligibility_dtls;
import com.web1.repo.Eligiblerepo;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private Eligiblerepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Eligibility_dtls entity1 = new Eligibility_dtls();
		
		entity1.setElig_ID(1);
		entity1.setName("Naveen");
		entity1.setMobile(9848756642l);
		entity1.setGender('M');
		entity1.setSsn(989888988l);
		entity1.setPlan_name("SNAP");
		entity1.setPlan_status("Approved");
		repo.save(entity1);
		
		
		Eligibility_dtls entity2 = new Eligibility_dtls();
		
		entity2.setElig_ID(2);
		entity2.setName("Raj");
		entity2.setMobile(8897756642l);
		entity2.setGender('M');
		entity2.setSsn(669888988l);
		entity2.setPlan_name("CCAP");
		entity2.setPlan_status("Denied");
		repo.save(entity2);
		
		
		Eligibility_dtls entity3 = new Eligibility_dtls();
		
		entity3.setElig_ID(3);
		entity3.setName("Rani");
		entity3.setMobile(9775622338l);
		entity3.setGender('F');
		entity3.setSsn(669877388l);
		entity3.setPlan_name("MediCaid");
		entity3.setPlan_status("Closed");
		repo.save(entity3);
		
	}

}
