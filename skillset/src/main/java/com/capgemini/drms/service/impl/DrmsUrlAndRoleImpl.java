package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsAllUrlAndRoleDao;
import com.capgemini.drms.service.DrmsUrlAndRoleService;
@Service("DrmsUrlAndRoleService")
public class DrmsUrlAndRoleImpl implements DrmsUrlAndRoleService {
	@Autowired
	private DrmsAllUrlAndRoleDao drmsAllUrlAndRoleDao;
	public List<String> findAllUrl() {
		// TODO Auto-generated method stub
		return drmsAllUrlAndRoleDao.findAllUrl();
	}

	public List<String> findAllRoleByUrl(String url) {
		// TODO Auto-generated method stub
		return drmsAllUrlAndRoleDao.findAllRoleByUrl(url);
	}

}
