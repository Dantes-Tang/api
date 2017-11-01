package com.capgemini.drms.model;

public class DrmsOpp {
	
	
 private int oppId;
 private String oppShowId;
 private String oppName;
 private String oppProbability;
 private DrmsStatus drmsStatus;  
 private DrmsAccount drmsAccount; 

 
 public String getOppShowId() {
	 return oppShowId;
 }
 public void setOppShowId(String oppShowId) {
	 this.oppShowId = oppShowId;
 }
public DrmsAccount getDrmsAccount() {
	return drmsAccount;
}
public void setDrmsAccount(DrmsAccount drmsAccount) {
	this.drmsAccount = drmsAccount;
}

public int getOppId() {
	return oppId;
}
public void setOppId(int oppId) {
	this.oppId = oppId;
}
public String getOppName() {
	return oppName;
}
public void setOppName(String oppName) {
	this.oppName = oppName;
}
public String getOppProbability() {
	return oppProbability;
}
public void setOppProbability(String oppProbability) {
	this.oppProbability = oppProbability;
}
public DrmsStatus getDrmsStatus() {
	return drmsStatus;
}
public void setDrmsStatus(DrmsStatus drmsStatus) {
	this.drmsStatus = drmsStatus;
}

}
