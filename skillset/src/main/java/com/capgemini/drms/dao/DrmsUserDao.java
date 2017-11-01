package com.capgemini.drms.dao;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;

/** 
* @ClassName: DrmsUserDao 
* @Description: TODO 
* @author winson luo
* @date Feb 14, 2017 12:50:23 PM 
*  
*/
@Repository
public interface DrmsUserDao {
	public String getLoginUserName(String shortName);
	public CapgUser getUserInfo(String fullnameString);
	public void updateUserInfo(CapgUser user);
	public void updateFacePic(CapgUser user);
}
