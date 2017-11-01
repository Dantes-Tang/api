package com.capgemini.drms.model;

import java.util.List;

public class DrmsSDAC {
	private List<DrmsDemand> drsDemand;
	private List<DrmsAllocationType> drmsAllocationType;
	private List<DrmsSite> drmsSite;
	private List<DrmsDesigation> drmsDesigation;
	private List<DrmsResource> drmsResource;
	private List<DrmsCapability> drmsCapability;
	private List<DrmsCapability> drmsAssCapability;
	public List<DrmsDemand> getDrsDemand() {
		return drsDemand;
	}
	public void setDrsDemand(List<DrmsDemand> drsDemand) {
		this.drsDemand = drsDemand;
	}
	public List<DrmsAllocationType> getDrmsAllocationType() {
		return drmsAllocationType;
	}
	public void setDrmsAllocationType(List<DrmsAllocationType> drmsAllocationType) {
		this.drmsAllocationType = drmsAllocationType;
	}
	public List<DrmsResource> getDrmsResource() {
		return drmsResource;
	}
	public void setDrmsResource(List<DrmsResource> drmsResource) {
		this.drmsResource = drmsResource;
	}
	public List<DrmsSite> getDrmsSite() {
		return drmsSite;
	}
	public void setDrmsSite(List<DrmsSite> drmsSite) {
		this.drmsSite = drmsSite;
	}
	public List<DrmsDesigation> getDrmsDesigation() {
		return drmsDesigation;
	}
	public void setDrmsDesigation(List<DrmsDesigation> drmsDesigation) {
		this.drmsDesigation = drmsDesigation;
	}
	public List<DrmsCapability> getDrmsCapability() {
		return drmsCapability;
	}
	public void setDrmsCapability(List<DrmsCapability> drmsCapability) {
		this.drmsCapability = drmsCapability;
	}
	public List<DrmsCapability> getDrmsAssCapability() {
		return drmsAssCapability;
	}
	public void setDrmsAssCapability(List<DrmsCapability> drmsAssCapability) {
		this.drmsAssCapability = drmsAssCapability;
	}
	

}
