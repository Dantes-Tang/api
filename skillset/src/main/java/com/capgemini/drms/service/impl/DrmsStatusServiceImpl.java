package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsStatusDao;
import com.capgemini.drms.model.DrmsStatus;
import com.capgemini.drms.service.DrmsStatusService;

@Service
public class DrmsStatusServiceImpl implements DrmsStatusService {
	@Autowired
	DrmsStatusDao drmsStatusDao;

	public List<DrmsStatus> searchStatusAll() {
		return drmsStatusDao.searchStatusAll();
	}

	public int updateDrmsStatus(DrmsStatus drmsStatus) {
		
		return drmsStatusDao.updateDrmsStatus(drmsStatus);
	}

	public int insertDrmsStatus(DrmsStatus drmsStatus) {
		return drmsStatusDao.insertDrmsStatus(drmsStatus);
	}

	}


