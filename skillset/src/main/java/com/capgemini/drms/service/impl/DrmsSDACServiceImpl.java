package com.capgemini.drms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsAllocationTypeDao;
import com.capgemini.drms.dao.DrmsCapabilityDao;
import com.capgemini.drms.dao.DrmsDesigationDao;
import com.capgemini.drms.dao.DrmsResourceDao;
import com.capgemini.drms.dao.DrmsSiteDao;
import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsSDAC;
import com.capgemini.drms.service.DrmsSDACService;

@Service(value="DrmsSDACService")
public class DrmsSDACServiceImpl implements DrmsSDACService {
	@Autowired
	private DrmsSiteDao drmsSiteDao;
	@Autowired
	private DrmsAllocationTypeDao drmsAllocationTypeDao;
	@Autowired
	private DrmsDesigationDao drmsDesigationDao;
	@Autowired
	private DrmsCapabilityDao drmsCapabilityDao;
	@Autowired
	private DrmsResourceDao drmsResourceDao;
	public DrmsSDAC searchDrmsSDAC(String resoureName) {
		// TODO Auto-generated method stub
		DrmsSDAC drmsSDAC = new DrmsSDAC();
		drmsSDAC.setDrmsSite(drmsSiteDao.searchDrmsSiteAll());
		drmsSDAC.setDrmsAllocationType(drmsAllocationTypeDao.searchAllocationTypeAll());
		drmsSDAC.setDrmsDesigation(drmsDesigationDao.searchAllDrmsDesigation());
		drmsSDAC.setDrmsCapability(drmsCapabilityDao.searchDrmsCapabilityAll());
		drmsSDAC.setDrmsResource(drmsResourceDao.searchDrmsResourceAll(resoureName));
		drmsSDAC.setDrmsAssCapability(drmsCapabilityDao.searchDrmsCapabilityAll());
		return drmsSDAC;
	}
	
	
	

}
