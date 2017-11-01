package com.capgemini.drms.model;

/**
 * @author dantang,create on Oct 7, 2016
 *
 */
public class DrmsCapability {
	private int capId;
	private String capName;
	private String capManager;
	private String capShortName;
	
	public int getCapId() { 
		return capId;
	}
	public void setCapId(int capId) {
		this.capId = capId;
	}
	public String getCapName() {
		return capName;
	}
	public void setCapName(String capName) {
		this.capName = capName;
	}
	public String getCapManager() {
		return capManager;
	}
	public void setCapManager(String capManager) {
		this.capManager = capManager;
	}
	public String getCapShortName() {
		return capShortName;
	}
	public void setCapShortName(String capShortName) {
		this.capShortName = capShortName;
	}
	
}
