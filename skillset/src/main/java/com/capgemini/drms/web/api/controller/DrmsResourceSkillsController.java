/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsResourceSkills;
import com.capgemini.drms.service.DrmsResourceSkillsService;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 13, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@Controller
@RequestMapping(value="/api/DrmsResourceSkills/")
public class DrmsResourceSkillsController {
@Autowired
private DrmsResourceSkillsService drmsResourceSkillsService;
@RequestMapping(value="/find",method=RequestMethod.POST)
public @ResponseBody List<DrmsResourceSkills> findDrmsResourceSkills(@RequestBody DrmsResourceSkills drmsResourceSkills){
	List<DrmsResourceSkills> list2=new ArrayList<DrmsResourceSkills>();
	List<DrmsResourceSkills>list1=drmsResourceSkillsService.findDrmsResourceSkills(drmsResourceSkills);
	for (DrmsResourceSkills drmsResourceSkills2 : list1) {
		DrmsResourceSkills drmsResourceSkills3=drmsResourceSkillsService.findDrmsResourceDsg(drmsResourceSkills2.getResourceId());
		if (!(drmsResourceSkills3.getDesigation().isEmpty())) {
		drmsResourceSkills2.setDesigation(drmsResourceSkills3.getDesigation());
		list2.add(drmsResourceSkills2);
		}else {
		list2.add(drmsResourceSkills2);
		}
	}
	return list2;
}
}
