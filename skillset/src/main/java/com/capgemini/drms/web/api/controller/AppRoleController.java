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

import com.capgemini.drms.model.AppDictionarySearchModel;
import com.capgemini.drms.model.AppRole;
import com.capgemini.drms.service.AppRoleService;

@Controller
@RequestMapping("/api/AppRole")
public class AppRoleController {

	@Autowired
	private AppRoleService appRoleService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean add(@RequestBody AppRole appRole,
			HttpServletRequest request) {
		if (appRoleService.insertAppRole(appRole) > 0)
			return true;

		return false;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean update(@RequestBody AppRole appRole,
			HttpServletRequest request) {
		if (appRoleService.updateAppRole(appRole) > 0)
			return true;

		return false;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody boolean deleteAppDictionary(@RequestParam int id) {
		if (appRoleService.deleteAppRole(id) > 0)
			return true;
		return false;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<AppRole> searchAppDictionaryBySearcher(
			@RequestBody AppDictionarySearchModel searcher) {
		return appRoleService.searchAppRoleBySearcher(searcher);

	}

	@RequestMapping(value = "/showUser", method = RequestMethod.POST)
	public @ResponseBody List<Object> showUser() {
		return null;

	}

	@RequestMapping(value = "/selectAppRole", method = RequestMethod.GET)
	public @ResponseBody List<AppRole> selectAppRole() {
		return appRoleService.selectAppRole();
	}
}
