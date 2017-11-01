package com.capgemini.drms.model;

import java.util.Date;


public class DrmsDemand {
	private int dmdId;
	private DrmsOpp drmsOpp;
	private String dmdResType;
	private DrmsResource drmsResource;
	private DrmsSite drmsSite;
	private DrmsDesigation drmsDesigation;
	private String dmdAlterdsg;
	private String dmdProjName;
	private String dmdPosition;
	private DrmsCapability drmsAssCapability;
	private DrmsAllocationType drmsAllocationType;
	private String dmdAllocRatio;
	private Date startDate;
	private Date endDate;
	private DrmsCapability drmsCapability;
	private String dmdShowId;
	private int resourceId;
	private DrmsDemandStatus drmsDemandStatus;
	
	
	public DrmsDemandStatus getDrmsDemandStatus() {
		return drmsDemandStatus;
	}
	public void setDrmsDemandStatus(DrmsDemandStatus drmsDemandStatus) {
		this.drmsDemandStatus = drmsDemandStatus;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public DrmsCapability getDrmsAssCapability() {
		return drmsAssCapability;
	}
	public void setDrmsAssCapability(DrmsCapability drmsAssCapability) {
		this.drmsAssCapability = drmsAssCapability;
	}
	public DrmsOpp getDrmsOpp() {
		return drmsOpp;
	}
	public void setDrmsOpp(DrmsOpp drmsOpp) {
		this.drmsOpp = drmsOpp;
	}
	public String getDmdResType() {
		return dmdResType;
	}
	public void setDmdResType(String dmdResType) {
		this.dmdResType = dmdResType;
	}
	public DrmsResource getDrmsResource() {
		return drmsResource;
	}
	public void setDrmsResource(DrmsResource drmsResource) {
		this.drmsResource = drmsResource;
	}
	public DrmsSite getDrmsSite() {
		return drmsSite;
	}
	public void setDrmsSite(DrmsSite drmsSite) {
		this.drmsSite = drmsSite;
	}
	public DrmsDesigation getDrmsDesigation() {
		return drmsDesigation;
	}
	public void setDrmsDesigation(DrmsDesigation drmsDesigation) {
		this.drmsDesigation = drmsDesigation;
	}
	public DrmsAllocationType getDrmsAllocationType() {
		return drmsAllocationType;
	}
	public void setDrmsAllocationType(DrmsAllocationType drmsAllocationType) {
		this.drmsAllocationType = drmsAllocationType;
	}
	public DrmsCapability getDrmsCapability() {
		return drmsCapability;
	}
	public void setDrmsCapability(DrmsCapability drmsCapability) {
		this.drmsCapability = drmsCapability;
	}

	
	public int getDmdId() {
		return dmdId;
	}
	public void setDmdId(int dmdId) {
		this.dmdId = dmdId;
	}

	public String getDmdAlterdsg() {
		return dmdAlterdsg;
	}
	public void setDmdAlterdsg(String dmdAlterdsg) {
		this.dmdAlterdsg = dmdAlterdsg;
	}
	public String getDmdProjName() {
		return dmdProjName;
	}
	public void setDmdProjName(String dmdProjName) {
		this.dmdProjName = dmdProjName;
	}
	public String getDmdPosition() {
		return dmdPosition;
	}
	public void setDmdPosition(String dmdPosition) {
		this.dmdPosition = dmdPosition;
	}
	public String getDmdAllocRatio() {
		return dmdAllocRatio;
	}
	public void setDmdAllocRatio(String dmdAllocRatio) {
		this.dmdAllocRatio = dmdAllocRatio;
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
	public String getDmdShowId() {
		return dmdShowId;
	}
	public void setDmdShowId(String dmdShowId) {
		this.dmdShowId = dmdShowId;
	}

}
