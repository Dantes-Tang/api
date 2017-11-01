package com.capgemini.drms.service;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;

@Repository
public interface UserService {
	public String getLoginUserName();
	CapgUser getUserInfo(String fullnameString);
	void updateUserInfo(CapgUser user);
	public String updateFacePic(String fileName);
}
