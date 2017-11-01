package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsAllocationType;
import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.service.DrmsAllocationTypeService;

@Controller
@RequestMapping(value = "/api/drmsAllocationType")
public class DrmsAllocationTypeController {
	@Autowired
	DrmsAllocationTypeService drmsAllocationTypeService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody boolean insertDrmsAllocationType(
			DrmsAllocationType drmsAllocationType) {

		if (drmsAllocationTypeService
				.insertDrmsAllocationType(drmsAllocationType) > 0) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public @ResponseBody List<DrmsAllocationType> searchAllocationTypeAll(
			@RequestParam int id) {
		return drmsAllocationTypeService.searchAllocationTypeAll();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateDrmsApplicationType(
			DrmsAllocationType drmsAllocationType) {
		if (drmsAllocationTypeService
				.updateDrmsAllocationType(drmsAllocationType) > 0) {
			return true;
		}
		return false;
	}
}
