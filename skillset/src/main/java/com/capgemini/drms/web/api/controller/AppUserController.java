package com.capgemini.drms.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.service.AppUserService;

@Controller
@RequestMapping("/api/AppUser")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;

	@RequestMapping(value = "/findFullName", method = RequestMethod.GET)
	public @ResponseBody String findFullName(@RequestParam String email) {
		return appUserService.findFullName(email);
	}
}
