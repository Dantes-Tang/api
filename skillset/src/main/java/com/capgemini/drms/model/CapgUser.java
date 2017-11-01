/* Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights
 * reserved.
 * Use is subject to license terms. */

package com.capgemini.drms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// TODO Add class/interface import here and remove this line.

/**
 * System User Info
 * 
 * @author calvye, create on 6 Jun 2012 Revision History: TODO Revised by XXXX
 *         on 201x/xx/xx, modified xxx
 */

public class CapgUser implements Serializable, UserDetails {
	private int id;
	private String domain;
	private String userName;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private String joinDate;
	private String employeeId;
	private String ChineseName;
	private String phone;
	private String mobile;
	private String homeAddress;
	private String EcontactName;
	private String EcontactNumber;
	private String manager;
	private String facePic;
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
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

		// authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

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

	public String getChineseName() {
		return ChineseName;
	}

	public void setChineseName(String chineseName) {
		ChineseName = chineseName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getEcontactName() {
		return EcontactName;
	}

	public void setEcontactName(String econtactName) {
		EcontactName = econtactName;
	}



	public String getEcontactNumber() {
		return EcontactNumber;
	}

	public void setEcontactNumber(String econtactNumber) {
		EcontactNumber = econtactNumber;
	}

	public List<SkillMatrix> getSkillMatrixes() {
		return skillMatrixes;
	}

	public void setSkillMatrixes(List<SkillMatrix> skillMatrixes) {
		this.skillMatrixes = skillMatrixes;
	}

	public List<Flexibility> getFlexibilities() {
		return flexibilities;
	}

	public void setFlexibilities(List<Flexibility> flexibilities) {
		this.flexibilities = flexibilities;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getFacePic() {
		return facePic;
	}

	public void setFacePic(String facePic) {
		this.facePic = facePic;
	}

	
	
}
