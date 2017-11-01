/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsResourceDao;
import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsResourceSkills;
import com.capgemini.drms.service.DrmsResourceSkillsService;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 13, 2017 Revision History: TODO Revised by XXXX
 *         on 201x/xx/xx, modified xxx
 */
@Service(value="DrmsResourceSkillsService")
public class DrmsResourceSkillsServiceImpl implements DrmsResourceSkillsService {
	@Autowired
	private DrmsResourceDao drmsResourceDao;

	@Override
	public List<DrmsResourceSkills> findDrmsResourceSkills(
			DrmsResourceSkills drmsResourceSkills) {
		// TODO Auto-generated method stub
		return drmsResourceDao.findDrmsResourceSkills(drmsResourceSkills);
	}
	public DrmsResourceSkills findDrmsResourceDsg(String resourceId){
		return drmsResourceDao.findDrmsResourceDsg(resourceId);
	};
}
