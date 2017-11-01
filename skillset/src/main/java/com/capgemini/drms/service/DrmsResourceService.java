package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.SkillMatrix;

@Repository
public interface DrmsResourceService {
	public List<DrmsResource> searchDrmsResourceAll();
	public String searchName(int resourceId);
		
}
