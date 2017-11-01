/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.dao;

import com.capgemini.drms.model.CapgUser;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author calvye, create on 22 Mar 2013
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
public interface LdapUserDao
{

	/**
	 * Get the User Info from LDAP by username
	 * @param userName
	 * @return
	 */
    public CapgUser loadCapgUserFromLdap(String userName);
}
