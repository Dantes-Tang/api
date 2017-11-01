package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsAccount;
import com.capgemini.drms.service.DrmsAccountService;

@Controller
@RequestMapping(value="api/drmsAccount")
public class DrmsAccountController {
	@Autowired
	DrmsAccountService  drmsAccountService;
	
	@RequestMapping(value="/get" ,method=RequestMethod.POST)
	public @ResponseBody List<DrmsAccount>  getAll()
	{
		return drmsAccountService.getAll();
	}
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	 public @ResponseBody boolean updateDrmsAccount(@RequestBody DrmsAccount drmsAccount)
	 {
		 if(drmsAccountService.updateDrmsAccount(drmsAccount)>0) return true;
		 return false;
	 }
	@RequestMapping(value="/insert" ,method=RequestMethod.POST)
	 public @ResponseBody boolean insertDrmsAccount(@RequestBody DrmsAccount drmsAccount)
	 {
		if( drmsAccountService.insertDrmsAccount(drmsAccount)>0) return true;
		 return false;
	 }
 }
