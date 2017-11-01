package com.capgemini.drms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsUserDao;
import com.capgemini.drms.dao.LdapUserDao;
import com.capgemini.drms.dao.impl.LdapUserDaoImpl;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.service.UserService;
@Service(value="UserService")

public class UserServiceImpl implements UserService {
	@Autowired
	private LdapUserDaoImpl ldapUserDaoImpl;
	@Autowired
	private DrmsUserDao drmsUserDao;
	
	public String getFullNameByShortName( String shortName) {
			return ldapUserDaoImpl.getLDAPUser(shortName).getFullName();
	}
	public String getLoginUserName(){
		SecurityContext s =SecurityContextHolder.getContext();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nemeString=userDetails.getUsername().trim();
		return drmsUserDao.getLoginUserName(nemeString);
	}
	@Override
	public CapgUser getUserInfo(String fullnameString) {
		CapgUser capgUser= new CapgUser();
		capgUser=drmsUserDao.getUserInfo(fullnameString);
		String manager = getFullNameByShortName(capgUser.getManager());
		capgUser.setManager(manager);
		return capgUser;
	}
	@Override
	public void updateUserInfo(CapgUser user) {
		drmsUserDao.updateUserInfo(user);
		
	}
	@Override
	public String updateFacePic(String fileName){
		CapgUser user= new CapgUser();
		user.setFullName(getLoginUserName());
		String facePic="http://10.61.213.114:8083/DrmsStaticResource/images/"+fileName;
		user.setFacePic(fileName);
		drmsUserDao.updateFacePic(user);
		return facePic;
	}

}
