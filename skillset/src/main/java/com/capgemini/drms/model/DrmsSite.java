package com.capgemini.drms.model;

/** 
* @ClassName: DrmsSite 
* @Description: TODO 
* @author winson luo
* @date Feb 24, 2017 6:14:52 PM 
*  
*/
public class DrmsSite {
	private int siteId;
	private String siteName;
	private String siteshortName;
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteshortName() {
		return siteshortName;
	}
	public void setSiteshortName(String siteshortName) {
		this.siteshortName = siteshortName;
	}
}
