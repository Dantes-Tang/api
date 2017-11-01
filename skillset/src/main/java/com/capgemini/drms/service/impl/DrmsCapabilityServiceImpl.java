package com.capgemini.drms.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsCapabilityDao;
import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.service.DrmsCapabilityService;
@Service(value ="DrmsCapabilityService")
public class DrmsCapabilityServiceImpl implements DrmsCapabilityService {
 
	@Autowired
	 DrmsCapabilityDao  drmsCapabilityDao;
	public int updateDrmsCapability(DrmsCapability drmsDemand) {

	    return  drmsCapabilityDao.updateDrmsCapability(drmsDemand);
				
	}

	public int insertDrmsCapability(DrmsCapability drmsDemand) {

		return  drmsCapabilityDao.insertDrmsCapability(drmsDemand);
	}

	public List<DrmsCapability> searchDrmsCapabilityAll() {

		return drmsCapabilityDao.searchDrmsCapabilityAll();
	}

}
