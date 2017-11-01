package com.capgemini.drms.service;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;
@Repository
public interface UserPermissionService  {
	
	public List<String> findUserPermission(String userName);
	
	public List<Map<String, String>> findUser(String username);
	
	public List<String> findIDByUserName(String userName);
	
	public int addCapgUser(CapgUser capgUser);
	
	public int addCapgUserRole(String UserID);
	
	public List<Map<String,String>> findUserInformation(String userName);
	
}
