package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsResourceSkills;
import com.capgemini.drms.model.SkillMatrix;

@Repository
public interface DrmsResourceDao {
	public List<DrmsResource> searchDrmsResourceAll(String resourceName);
	public String searchName(int resourceId);
	public DrmsResource searchResourceId(String resourceName);
	public List<DrmsResourceSkills> findDrmsResourceSkills(DrmsResourceSkills drmsResourceSkills);
	public DrmsResourceSkills findDrmsResourceDsg(String resourceId);
}
