package com.capgemini.drms.dao;

import java.util.List;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.CapgUserRole;

public interface DbUserDao {
	public List<CapgUser> loadCapgUserByName();

	/**
	 * functional description：deleteCapgUser with userName
	 * 
	 * @param userName
	 * @return
	 */
	public int deleteCapgUser(String fullName);

	/**
	 * functional description：getCapgUser with userName
	 * 
	 * @param userName
	 * @return
	 */
	public CapgUser getCapgUser(String fullName);

	/**
	 * functional description：updateCapgUsers
	 * 
	 * @param capgUser
	 * @return
	 */
	public int updateCapgUsers(CapgUser capgUser);

	/**
	 * functional description：findcCapgUsers
	 * 
	 * @param userName
	 * @return
	 */
	public List<CapgUser> findcCapgUsers(String userName);

	public List<CapgUserRole> findCapgUserRole(String fullName);

	public List<CapgUserRole> findCapgUserRoles();
	public CapgUserRole findCapgUserRoleID(String fullName);
	public int insertCapgUserRole(CapgUserRole capgUserRole);
	public List<String> findRoleIDByRoleName(List<String> roleName);
	public int addCapgUserRoles(CapgUserRole capgUserRole);
	/**
	 * dataUPdate
	 */
	public CapgUserRole findCapgUserRoleName(String fullName);
	public int deleteCapgUserRole(CapgUserRole capgUserRole);
	public int updateCapgUserRoles( CapgUserRole capgUserRole);
	
}