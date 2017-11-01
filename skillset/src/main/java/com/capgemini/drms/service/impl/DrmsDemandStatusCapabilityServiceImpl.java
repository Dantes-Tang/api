/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsDemandStatusCapabilityDao;
import com.capgemini.drms.model.DrmsDemandStatusCapability;
import com.capgemini.drms.service.DrmsDemandStatusCapabilityService;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 9, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@Service(value="DrmsDemandStatusCapabilityService")
public class DrmsDemandStatusCapabilityServiceImpl implements
DrmsDemandStatusCapabilityService {
@Autowired
private DrmsDemandStatusCapabilityDao drmsDemandStatusCapabilityDao;
	
	@Override
	public List<DrmsDemandStatusCapability> findDrmsDemandStatusCapabilities(
			DrmsDemandStatusCapability demandStatusCapability) {
		// TODO Auto-generated method stub
		return drmsDemandStatusCapabilityDao.findDrmsDemandStatusCapabilities(demandStatusCapability);
		
	}

}
