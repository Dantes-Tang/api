/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.capgemini.drms.model.CapgUser;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author calvye, create on Nov 12, 2015
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */

public class BaseController {

	/**
	 * 
	 * @return
	 */
	protected CapgUser getCurrentUser()
	{
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		
		if(userDetails instanceof User)
		{
			User user = (User)userDetails;
			CapgUser capgUser = new CapgUser();
			capgUser.setUserName(user.getUsername());
			
			
			return capgUser;
		}
		return (CapgUser)userDetails;
	}
}
