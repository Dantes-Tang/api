/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.web.api.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.CapgUserRole;
import com.capgemini.drms.model.SearchModel;
import com.capgemini.drms.service.FlexibilityService;
import com.capgemini.drms.service.UserService;
import com.capgemini.drms.util.FileUploadUtil;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author calvye, create on Nov 12, 2015 Revision History: TODO Revised by XXXX
 *         on 201x/xx/xx, modified xxx
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController {

	@Autowired
	private FlexibilityService flexibilityService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/searchCapgUser", method = RequestMethod.GET)
	public @ResponseBody List<CapgUser> searchCapgUser(
			@ModelAttribute SearchModel searchModel) {

		return flexibilityService.searchCapgUser(searchModel);

	}

	/**
	 * @author : winson luo
	 * @version ：Feb 13, 2017 4:47:34 PM
	 * @Title: getCurrentUserInfo
	 * @Description: TODO
	 * @param @return
	 * @return List<CapgUser>
	 * @throws
	 */
	@RequestMapping(value = "/getCurrentUserInfo", method = RequestMethod.GET)
	public @ResponseBody List<CapgUser> getCurrentUserInfo() {
		return flexibilityService.loadCapgUserByName();
	}

	/**
	 * @author : winson luo
	 * @version ：Feb 13, 2017 4:47:40 PM
	 * @Title: getLoginUserName
	 * @Description: TODO
	 * @param @return
	 * @return String[]
	 * @throws
	 */
	@RequestMapping(value = "/getLoginUserName", method = RequestMethod.GET)
	public @ResponseBody String[] getLoginUserName() {
		String[] name = new String[1];
		name[0] = userService.getLoginUserName();
		return name;
	}

	/**
	 * @author : winson luo
	 * @version ：Feb 13, 2017 4:47:46 PM
	 * @Title: getUserInfo
	 * @Description: TODO
	 * @param @return
	 * @return CapgUser
	 * @throws
	 */
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public @ResponseBody CapgUser getUserInfo() {
		String fullnameString = userService.getLoginUserName();
		return userService.getUserInfo(fullnameString);
	}

	/**
	 * @author : winson luo
	 * @version ：Feb 13, 2017 4:47:52 PM
	 * @Title: updateUserInfo
	 * @Description: TODO
	 * @param @param servletRequest
	 * @return void
	 * @throws
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
	public void updateUserInfo(HttpServletRequest servletRequest) {
		String employeeId = servletRequest.getParameter("employeeId");
		String chineseName = servletRequest.getParameter("chineseName");
		String mobile = servletRequest.getParameter("mobile");
		String homeAddress = servletRequest.getParameter("homeAddress");
		String econtactName = servletRequest.getParameter("econtactName");
		String econtactNumber = servletRequest.getParameter("econtactNumber");
		CapgUser capgUser = new CapgUser();
		capgUser.setEmployeeId(employeeId);
		capgUser.setChineseName(chineseName);
		capgUser.setMobile(mobile);
		capgUser.setHomeAddress(homeAddress);
		capgUser.setEcontactName(econtactName);
		capgUser.setEcontactNumber(econtactNumber);
		userService.updateUserInfo(capgUser);
		System.out.println("function finish");
	}

	/**
	 * @author : winson luo
	 * @version ：Feb 14, 2017 12:38:17 PM
	 * @Title: uploadFacePic
	 * @Description: TODO
	 * @param @param request
	 * @param @return
	 * @param @throws ServletException
	 * @param @throws IOException
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/uploadFacePic", method = RequestMethod.POST)
	public @ResponseBody String uploadFacePic(HttpServletRequest request)
			throws ServletException, IOException {
		String fileName = FileUploadUtil.upload(request);
		return userService.updateFacePic(fileName);
	}

	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody void updateUserInfo(CapgUser user) {
		userService.updateUserInfo(user);
	}

	/**
	 * functional description：deleteCapgUser with userName
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody boolean deleteCapgUser(@RequestParam String fullName) {
		if (flexibilityService.deleteCapgUser(String.valueOf(fullName)) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * functional description：getCapgUser with userName
	 * 
	 * @param userName
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public @ResponseBody void getCapgUser(@RequestParam String fullName,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CapgUser capgUser = flexibilityService.getCapgUser(fullName);
		if (capgUser != null) {
			request.setAttribute("capgUser", capgUser);
			request.getRequestDispatcher("capgeUserEdit.jsp").forward(request,
					response);
			return;
		}
	}

	/**
	 * functional description：updateCapgUsers
	 * 
	 * @param capgUser
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody boolean updateCapgUsers(CapgUser capgUser,
			HttpServletRequest request) {
		if (flexibilityService.updateCapgUsers(capgUser) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * functional description：findcCapgUsers
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public @ResponseBody List<CapgUser> findcCapgUsers(
			@RequestParam String userName) {
		return flexibilityService.findcCapgUsers(userName);
	}
	/**
	 * dataupdate
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public @ResponseBody CapgUserRole findCapgUserRoleName(String fullName,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CapgUserRole capgUserRole= flexibilityService.findCapgUserRoleName(fullName);
		if (capgUserRole != null) {
			request.setAttribute("capgUserRole", capgUserRole);
			request.getRequestDispatcher("capgeUserEdit.jsp").forward(request,
					response);
			return capgUserRole;
		}
		return capgUserRole;
		
	}
}