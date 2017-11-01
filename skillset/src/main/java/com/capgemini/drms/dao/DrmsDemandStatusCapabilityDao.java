/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsDemandStatusCapability;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 9, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@Repository
public interface DrmsDemandStatusCapabilityDao {
	public List<DrmsDemandStatusCapability> findDrmsDemandStatusCapabilities(DrmsDemandStatusCapability demandStatusCapability);
}
