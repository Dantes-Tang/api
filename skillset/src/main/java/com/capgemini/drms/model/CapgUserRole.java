/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.model;

import java.util.List;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 14, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */

public class CapgUserRole {
private String userId;
private String employeeId;
private String fullName;
private List<String> roleId;
private List<String> roleName;
private String roleNo;
private String role;


public String getRoleNo() {
	return roleNo;
}
public void setRoleNo(String roleNo) {
	this.roleNo = roleNo;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public List<String> getRoleId() {
	return roleId;
}
public void setRoleId(List<String> roleId) {
	this.roleId = roleId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public List<String> getRoleName() {
	return roleName;
}
public void setRoleName(List<String> roleName) {
	this.roleName = roleName;
}
@Override
public String toString() {
	return "CapgUserRole [userId=" + userId + ", employeeId=" + employeeId
			+ ", fullName=" + fullName + ", roleId=" + roleId + ", roleName="
			+ roleName + ", roleNo=" + roleNo + ", role=" + role + "]";
}

}
