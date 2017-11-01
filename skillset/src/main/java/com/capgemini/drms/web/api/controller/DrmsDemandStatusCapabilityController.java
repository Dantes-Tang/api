/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping(value="/api/DrmsDemandStatusCapability")
public class DrmsDemandStatusCapabilityController {
	
@Autowired
private DrmsDemandStatusCapabilityService drmsDemandStatusCapabilityService;

@RequestMapping(value="/find",method=RequestMethod.POST)
public @ResponseBody List<DrmsDemandStatusCapability> findDemandStatusCapabilities(@RequestBody DrmsDemandStatusCapability demandStatusCapability){

	return drmsDemandStatusCapabilityService.findDrmsDemandStatusCapabilities(demandStatusCapability);
}
}
