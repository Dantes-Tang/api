package com.capgemini.drms.service;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsCapability;

@Repository
public interface DrmsCapabilityService {
  
	 public int updateDrmsCapability(DrmsCapability drmsDemand);
	   
	 public int insertDrmsCapability(DrmsCapability drmsDemand);  
	  
     public List<DrmsCapability> searchDrmsCapabilityAll();
	   

		
}
