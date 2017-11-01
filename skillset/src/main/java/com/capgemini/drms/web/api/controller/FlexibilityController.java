package com.capgemini.drms.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.CapgUserRole;
import com.capgemini.drms.model.Country;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.service.FlexibilityService;

@Controller
@RequestMapping("/api/flexibility")
public class FlexibilityController extends BaseController {

	private static final Log logger = LogFactory
			.getLog(FlexibilityController.class);

	@Autowired
	private FlexibilityService flexibilityService;

	// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody List<Flexibility> add(
			@RequestBody List<Flexibility> flexibilityes,
			HttpServletRequest request) {

		flexibilityService.insertFlexibility(flexibilityes);

		return flexibilityService.loadFlexibilityByUsername(getCurrentUser()
				.getUserName());
	}

	@RequestMapping(value = "/getCountrys", method = RequestMethod.GET)
	public @ResponseBody List<Country> getCountrys() {

		return flexibilityService.getCountrys();

	}

	//
	@RequestMapping(value = "/getFlexibility", method = RequestMethod.GET)
	public @ResponseBody List<Flexibility> getFlexibility(
			@RequestParam("username") String username) {

		return flexibilityService.loadFlexibilityByUsername(username);
	}

	@RequestMapping(value = "/getCapgUserRole", method = RequestMethod.GET)
	public @ResponseBody List<CapgUserRole> findCapgUserRole(
			@RequestParam String fullName) {
		return flexibilityService.findCapgUserRole(fullName);
	};

	@RequestMapping(value = "/getfindCapgUserRoles", method = RequestMethod.POST)
	public @ResponseBody List<CapgUserRole> findCapgUserRoles() {
		return flexibilityService.findCapgUserRoles();
	}

	/**
	 * functional description:search all country by userName
	 *
	 * @author dantang 2/14/2017
	 * @retrun
	 * @throw
	 * @see
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	public @ResponseBody List<Flexibility> getCountry(
			@RequestParam String username) {
		return flexibilityService.searchCountryByUserName(username);
	}

	/**
	 * functional description: update duration in onSite
	 *
	 * @author dantang 2/14/2017
	 * @retrun
	 * @throw
	 * @see
	 * @param duration
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/updateCountry", method = RequestMethod.POST)
	public @ResponseBody boolean updateCountry(@RequestParam String duration,
			@RequestParam long id) {
		if (flexibilityService.updateDuration(duration, id) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/addCapgUserRoles", method = RequestMethod.POST)
	public @ResponseBody boolean insertCapgUserRole(
			@RequestBody CapgUserRole capgUserRole) {
		if (flexibilityService.addCapgUserRoles(capgUserRole)>0) {
			return true;
		}
		return false;
	}

	/**
	 * @param capgUserRole
	 * @return
	 */
	@RequestMapping(value = "/updateCapgUserRoles", method = RequestMethod.POST)
	public @ResponseBody boolean updateCapgUserRole(
			@RequestBody CapgUserRole capgUserRole) {
		if (flexibilityService.updateCapgUserRoles(capgUserRole)>0) {
			return true;
		}
		return false;

	}

	@RequestMapping(value = "/updateOradd", method = RequestMethod.POST)
	public @ResponseBody boolean updateOradd(
			@RequestBody List<Flexibility> flexibilities) {
		boolean flag = true;
		for (Flexibility flexibility : flexibilities) {
			if (flexibility.getDuration() == " "
					|| flexibility.getDuration().equals(" ")) {
				flag = false;
			} else {
				flexibilityService.addOrUpdate(flexibilities);
				flag = true;
			}
		}
		return flag;
	}
}