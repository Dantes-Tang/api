package com.capgemini.drms.model;

/** 
* @ClassName: DrmsAccount 
* @Description: TODO 
* @author winson luo
* @date Feb 24, 2017 5:20:36 PM 
*  
*/
public class DrmsAccount {
  private int  accountId;
  private String  accountName;
  private String  shortName;
  private String  accountPartner;
  
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public String getShortName() {
	return shortName;
}
public void setShortName(String shortName) {
	this.shortName = shortName;
}
public String getAccountPartner() {
	return accountPartner;
}
public void setAccountPartner(String accountPartner) {
	this.accountPartner = accountPartner;
}

}
