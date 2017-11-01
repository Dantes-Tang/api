package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsResourceDao;
import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.service.DrmsResourceService;

@Service(value=" DrmsResourceService")
public class DrmsResourceServiceImpl implements DrmsResourceService {
	@Autowired
	private DrmsResourceDao drmsResourceDao;
	public List<DrmsResource> searchDrmsResourceAll(String resourceName){
		return drmsResourceDao.searchDrmsResourceAll(resourceName);
	}
	public List<DrmsResource> searchDrmsResourceAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public String searchName(int resourceId) {
		// TODO Auto-generated method stub
		return  drmsResourceDao.searchName(resourceId) ;
	}
}
