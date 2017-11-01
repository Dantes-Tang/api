package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsDemandStatusDao;
import com.capgemini.drms.model.DrmsDemandStatus;
import com.capgemini.drms.service.DrmsDemandStatusService;

@Service(value = "DrmsDemandStatusService")
public class DrmsDemandStatusServiceImpl implements DrmsDemandStatusService {
	@Autowired
	private DrmsDemandStatusDao drmsDemandStatusDao;
	
	@Override
	public List<DrmsDemandStatus> searchDemandStatuses() {
		// TODO Auto-generated method stub
		return drmsDemandStatusDao.searhcDemandStatuses();
	}

}
