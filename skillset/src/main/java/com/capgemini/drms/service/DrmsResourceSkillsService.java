/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsResourceSkills;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 13, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@Repository
public interface DrmsResourceSkillsService {
	public List<DrmsResourceSkills> findDrmsResourceSkills(DrmsResourceSkills drmsResourceSkills);
	public DrmsResourceSkills findDrmsResourceDsg(String resourceId);
}
