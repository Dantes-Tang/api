package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsResourceType;
import com.capgemini.drms.service.DrmsResourceTypeService;

@Controller
@RequestMapping(value = "/api/DrmsResourceType")
public class DrmsResourceTypeController {
	@Autowired
	private DrmsResourceTypeService drmsResourceTypeService;
	@RequestMapping(value="/searchAllResourceType",method=RequestMethod.GET)
	public @ResponseBody List<DrmsResourceType> searchAllResourceType(){
		return drmsResourceTypeService.searchAllDrmsResourceTypes();
	}

}
