/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.model;

import java.util.Date;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 9, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */

public class DrmsDemandStatusCapability {
	private int dmdID;
	private String accountName;
	private String capability;
	private String project;
	private String site;
	private String resourceType;
	private Date startDate;
	private Date endDate;
	private String resourceName;
	private String status;
	private String desigation;
	private String dmdShowID;
	private String oppProbability;
	private String oppName;
	public int getDmdID() {
		return dmdID;
	}
	public void setDmdID(int dmdID) {
		this.dmdID = dmdID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCapability() {
		return capability;
	}
	public void setCapability(String capability) {
		this.capability = capability;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getDesigation() {
		return desigation;
	}
	public void setDesigation(String desigation) {
		this.desigation = desigation;
	}
	
	public String getDmdShowID() {
		return dmdShowID;
	}
	public void setDmdShowID(String dmdShowID) {
		this.dmdShowID = dmdShowID;
	}
	public String getOppProbability() {
		return oppProbability;
	}
	public void setOppProbability(String oppProbability) {
		this.oppProbability = oppProbability;
	}
	public String getOppName() {
		return oppName;
	}
	public void setOppName(String oppName) {
		this.oppName = oppName;
	}
	@Override
	public String toString() {
		return "DrmsDemandStatusCapability [dmdID=" + dmdID + ", accountName="
				+ accountName + ", capability=" + capability + ", project="
				+ project + ", site=" + site + ", resourceType=" + resourceType
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", resourceName=" + resourceName + ", status=" + status
				+ ", desigation=" + desigation + ", dmdShowID=" + dmdShowID
				+ ", oppProbability=" + oppProbability + ", oppName=" + oppName
				+ "]";
	}
	
}
