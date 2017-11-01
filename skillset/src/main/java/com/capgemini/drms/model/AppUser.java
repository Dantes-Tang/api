/* Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights
 * reserved.
 * Use is subject to license terms. */
package com.capgemini.drms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// TODO Add class/interface import here and remove this line.

/**
 * System User Info
 * 
 * @author calvye, create on 6 Jun 2012 Revision History: TODO Revised by XXXX
 *         on 201x/xx/xx, modified xxx
 */

public class AppUser implements Serializable, UserDetails {
	private int id;
	private String domain;
	private String userName;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private Date joinDate;
	private String employeeId;

	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	private List<SkillMatrix> skillMatrixes;

	private List<Flexibility> flexibilities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		if (fullName != null && fullName.trim().length() > 0) {
			return fullName;
		} else {
			return this.firstName + " " + this.lastName;
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		return getUserName();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
