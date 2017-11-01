package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsAllocationTypeDao;
import com.capgemini.drms.model.DrmsAllocationType;
import com.capgemini.drms.service.DrmsAllocationTypeService;

@Service(value="DrmsAllocationTypeService")
public class DrmsAllocationTypeServiceImpl implements DrmsAllocationTypeService {
	@Autowired
	DrmsAllocationTypeDao drmsAllocationTypeDao;

	public int updateDrmsAllocationType(DrmsAllocationType drmsAllocationType) {
		return drmsAllocationTypeDao.updateDrmsAllocationType(drmsAllocationType);
	}

	public int insertDrmsAllocationType(DrmsAllocationType drmsAllocationType) {
		return drmsAllocationTypeDao.insertDrmsAllocationType(drmsAllocationType);
	}

	public List<DrmsAllocationType> searchAllocationTypeAll() {
		return drmsAllocationTypeDao.searchAllocationTypeAll();
	}
	

}
