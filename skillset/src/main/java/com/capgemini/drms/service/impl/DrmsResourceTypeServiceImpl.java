package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsResourceTypeDao;
import com.capgemini.drms.model.DrmsResourceType;
import com.capgemini.drms.service.DrmsResourceTypeService;

/**
 * functional description： XXXXXX
 * 
 * @author dantang @capgemini.com
 * @created Feb 21, 201710:24:38 AM
 * @date Feb 21, 201710:24:38 AM
 */
@Service(value = "DrmsResourceTypeService")
public class DrmsResourceTypeServiceImpl implements DrmsResourceTypeService {
	@Autowired
	private DrmsResourceTypeDao drmsResourceTypeDao;

	public List<DrmsResourceType> searchAllDrmsResourceTypes() {
		// TODO Auto-generated method stub
		return drmsResourceTypeDao.searchAllResourceType();
	}

}
