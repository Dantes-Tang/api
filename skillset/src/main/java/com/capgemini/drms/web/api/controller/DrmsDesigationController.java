package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.model.DrmsDesigation;
import com.capgemini.drms.service.DrmsDesigationService;

@Controller
@RequestMapping(value="/api/DrmsDesigation")
public class DrmsDesigationController {
	@Autowired
	private DrmsDesigationService drmsDesigationService;
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public @ResponseBody List<DrmsDesigation> searchDrmsDesigationAll() {
		return drmsDesigationService.searchAllDrmsDesigation();
	}
  
	
	
	

}
