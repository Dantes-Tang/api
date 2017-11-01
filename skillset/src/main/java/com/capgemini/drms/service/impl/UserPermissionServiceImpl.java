package com.capgemini.drms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.UserPermissionDao;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.service.UserPermissionService;
@Service (value="userPermissionService")

public class UserPermissionServiceImpl implements UserPermissionService {
	@Autowired 
	private UserPermissionDao userPermissionDao;
	    
		public List<String> findUserPermission(String userName) {
			
			return userPermissionDao.findUserPermission(userName);
		}
		
		
		public List<Map<String, String>> findUser(String username){
			System.out.println("through the Database");
			return userPermissionDao.findUser(username);
		}
		
		public List<String> findIDByUserName(String userName){
			
			return userPermissionDao.findIDByUserName(userName);
		}
		
		
		public List<Map<String,String>> findUserInformation(String userName){
			System.out.println("through the Database");
			return userPermissionDao.findUserInformation(userName);
		}
		
		public int addCapgUser(CapgUser capgUser){
			
			return userPermissionDao.addCapgUser(capgUser);
		}
		 
		public int addCapgUserRole(String UserID){
			
			return userPermissionDao.addCapgUserRole(UserID);
		}
}
