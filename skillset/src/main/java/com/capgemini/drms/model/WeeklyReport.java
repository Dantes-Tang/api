package com.capgemini.drms.model;

/**
 * @ClassName: Report
 * @Description: TODO
 * @author winson luo
 * @date Mar 7, 2017 5:38:45 PM
 * 
 */
public class WeeklyReport {
	private String capability;
	private String kinId;
	private String name;
	private String GlobalJoinDate;
	private String designation;
	private String BenchJoinDate;
	private String dmdAllocRatio;
	private String primarySkill;
	private String dmdRemarks;
	private int aging;
	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}

	public String getKinId() {
		return kinId;
	}

	public void setKinId(String kinId) {
		this.kinId = kinId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGlobalJoinDate() {
		return GlobalJoinDate;
	}

	public void setGlobalJoinDate(String globalJoinDate) {
		GlobalJoinDate = globalJoinDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBenchJoinDate() {
		return BenchJoinDate;
	}

	public void setBenchJoinDate(String benchJoinDate) {
		BenchJoinDate = benchJoinDate;
	}

	public String getDmdAllocRatio() {
		return dmdAllocRatio;
	}

	public void setDmdAllocRatio(String dmdAllocRatio) {
		this.dmdAllocRatio = dmdAllocRatio;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getDmdRemarks() {
		return dmdRemarks;
	}

	public void setDmdRemarks(String dmdRemarks) {
		this.dmdRemarks = dmdRemarks;
	}

	public int getAging() {
		return aging;
	}

	public void setAging(int aging) {
		this.aging = aging;
	}

	
	
}
