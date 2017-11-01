package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.AppDictionarySearchModel;
import com.capgemini.drms.model.AppRole;

@Repository
public interface AppRoleDao {

	public int updateAppRole(AppRole appRole);

	public int deleteAppRole(int id);

	public int insertAppRole(AppRole appRole);

	public List<AppRole> searchAppRoleBySearcher(AppDictionarySearchModel searcher);

	public List<AppRole> selectAppRole();
}
