package com.capgemini.drms.web.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.service.DrmsCapabilityService;

@Controller
@RequestMapping(value="api/drmscapability")
public class DrmsCapabilityController {
  @Autowired
  DrmsCapabilityService drmsCapabilityService;
 @RequestMapping(value="/update" ,method=RequestMethod.POST)
  public @ResponseBody boolean update(DrmsCapability drmsCapability ,HttpServletRequest request )
  {
	if(drmsCapabilityService.updateDrmsCapability(drmsCapability)>0)return true;
	 return false;
  }
 @RequestMapping(value="/insert",method=RequestMethod.POST)
 public @ResponseBody boolean insert(DrmsCapability drmsCapability, HttpServletRequest request)
 {
	if(drmsCapabilityService.insertDrmsCapability(drmsCapability)>0)return true;
	return false;
 }
 @RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<DrmsCapability> searchDrmsCapabilitieAll() {
		return drmsCapabilityService.searchDrmsCapabilityAll();
	}
  
}
