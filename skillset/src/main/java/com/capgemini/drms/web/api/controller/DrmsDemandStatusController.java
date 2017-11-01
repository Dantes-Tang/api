package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsDemandStatus;
import com.capgemini.drms.service.DrmsDemandStatusService;

@Controller
@RequestMapping(value = "/api/DrmsDemandStatus")
public class DrmsDemandStatusController {
	@Autowired
	private DrmsDemandStatusService demandStatusService;

	@RequestMapping(value = "/searchAllDemandStatus", method = RequestMethod.POST)
	public @ResponseBody List<DrmsDemandStatus> serachAllDemandStatus() {
		return demandStatusService.searchDemandStatuses();
	}

}
