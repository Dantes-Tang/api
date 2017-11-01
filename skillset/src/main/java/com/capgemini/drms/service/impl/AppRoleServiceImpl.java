package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.AppRoleDao;
import com.capgemini.drms.model.AppDictionarySearchModel;
import com.capgemini.drms.model.AppRole;
import com.capgemini.drms.service.AppRoleService;

@Service(value = "AppRoleService")
public class AppRoleServiceImpl implements AppRoleService {
	@Autowired
	private AppRoleDao appRoleDao;

	public int insertAppRole(AppRole appRole) {
		return appRoleDao.insertAppRole(appRole);
	}

	public int updateAppRole(AppRole appRole) {

		return appRoleDao.updateAppRole(appRole);
	}

	public int deleteAppRole(int id) {
		return appRoleDao.deleteAppRole(id);
	}

	public List<AppRole> searchAppRoleBySearcher(AppDictionarySearchModel searcher) {
		return appRoleDao.searchAppRoleBySearcher(searcher);
	}

	public List<AppRole> selectAppRole() {
		return appRoleDao.selectAppRole();
	}
}
