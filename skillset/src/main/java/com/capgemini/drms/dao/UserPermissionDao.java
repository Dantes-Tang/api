package com.capgemini.drms.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;
@Repository
public interface UserPermissionDao {
	/**
	 * function:findUserPermission
	 * @param userName
	 * @return user's permission
	 */
	public List<String> findUserPermission(String userName);
	/**
	 * function:findUser
	 * @param username
	 * @return user's individual information
	 */
	public List<Map<String, String>> findUser(String userName);
	/**
	 * function:findIDByUserName
	 * @param userName
	 * @return judge the user is or isn't exist in our database
	 */
	public List<String> findIDByUserName(String userName);
	/**
	 * function:addCapgUser
	 * @param userName
	 * @return insert the user information into database
	 */
	public int addCapgUser(CapgUser capgUser);
	/**
	 * function:addCapguserRole
	 * @param UserID
	 * @return give the permission to user  
	 */
	public int addCapgUserRole(String UserID);
	/**
	 * function:findUserInformation
	 * @param userName
	 * @return find the user's information and put them into cache
	 */
	public List<Map<String,String>> findUserInformation(String userName);
}
