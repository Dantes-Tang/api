package com.capgemini.drms.web.api.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsSDAC;
import com.capgemini.drms.service.DrmsSDACService;

@Controller
@RequestMapping("/api/DrmsSDAC")
public class DrmsSDACController {
	@Autowired
	private DrmsSDACService drmsSDACService;
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public @ResponseBody DrmsSDAC  searchDrmsSDACBySearcher(String resourceName) {
		resourceName = "TBD";
		return drmsSDACService.searchDrmsSDAC(resourceName);
	}
}
