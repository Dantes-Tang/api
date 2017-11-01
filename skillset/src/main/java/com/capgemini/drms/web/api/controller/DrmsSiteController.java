package com.capgemini.drms.web.api.controller;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.service.DrmsSiteService;

@Controller
@RequestMapping("/api/DrmsSite")
public class DrmsSiteController {
	@Autowired
	private DrmsSiteService drmsSiteService;
	public @ResponseBody boolean update(@RequestBody DrmsSite drmsSite, HttpServletRequest request) {
		if (drmsSiteService.updateDrmsSite(drmsSite) > 0)
			return true;
		return false;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean add(@RequestBody DrmsSite drmsSite, HttpServletRequest request) {
		if (drmsSiteService.insertDrmsSite(drmsSite) > 0)
			return true;
		return false;

	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<DrmsSite> searchDrmsSiteBySearcher() {
		return drmsSiteService.searchDrmsSiteAll();
	}
}
