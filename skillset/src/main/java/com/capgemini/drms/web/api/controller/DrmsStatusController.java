package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsStatus;
import com.capgemini.drms.service.DrmsStatusService;

@Controller
@RequestMapping(value = "/api/drmsStatus")
public class DrmsStatusController {
	@Autowired
	DrmsStatusService drmsStatusService;
	
	@RequestMapping(value="/get" ,method=RequestMethod.POST)
	public @ResponseBody List<DrmsStatus> searchStatusAll(){
		return drmsStatusService.searchStatusAll();
	}
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	 public @ResponseBody boolean updateDrmsAccount(@RequestBody DrmsStatus drmsStatus)
	 {
		if( drmsStatusService.updateDrmsStatus(drmsStatus)>0)  return true;
		 return false;
	 }
	@RequestMapping(value="/insert" ,method=RequestMethod.POST)
	 public @ResponseBody boolean insertDrmsAccount(@RequestBody DrmsStatus drmsStatus)
	 {
		 if(drmsStatusService.insertDrmsStatus(drmsStatus)>0) return true;
		return false;
	 }

}
