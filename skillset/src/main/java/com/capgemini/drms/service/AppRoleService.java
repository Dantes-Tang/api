package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.AppDictionarySearchModel;
import com.capgemini.drms.model.AppRole;

@Repository
public interface AppRoleService {

	public int insertAppRole(AppRole appRole);

	public int updateAppRole(AppRole appRole);

	public int deleteAppRole(int id);

	public List<AppRole> searchAppRoleBySearcher(AppDictionarySearchModel searcher);

	public List<AppRole> selectAppRole();
}
