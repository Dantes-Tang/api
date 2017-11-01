package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.CapgUserRole;
import com.capgemini.drms.model.Country;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SearchModel;

@Repository
public interface FlexibilityService {

	public List<CapgUser> searchCapgUser(SearchModel searchModel);

	public List<Country> getCountrys();

	public void updateFlexibility(Flexibility flexibility);

	public List<Flexibility> loadFlexibilityByUsername(String username);

	public void insertFlexibility(Flexibility flexibility);

	public void insertFlexibility(List<Flexibility> flexibilityes);

	public void deleteFlexibility(String username);

	public List<CapgUser> loadCapgUserByName();

	public List<CapgUserRole> findCapgUserRole(String fullName);

	/**
	 * functional description：getCapgUser with userName
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

	public List<CapgUserRole> findCapgUserRoles();

	/**
	 * functional description:
	 *
	 * @param
	 * @retrun
	 * @throw
	 * @see
	 * @param userName
	 * @return
	 */
	public List<Flexibility> searchCountryByUserName(String userName);

	/**
	 * functional description:
	 *
	 * @param
	 * @retrun
	 * @throw
	 * @see
	 * @param duration
	 * @param id
	 * @return
	 */
	public int updateDuration(String duration, long id);
	/**
	 *functional description:add or update items in onSite
	 *@param
	 *@author dantang
	 *@throw
	 *@see  
	 * @param flexibility
	 * @return
	 */
	public boolean addOrUpdate(List<Flexibility> flexibility);

	public CapgUserRole findCapgUserRoleID(String fullName);

	public int insertCapgUserRole(CapgUserRole capgUserRole);

	public List<String> findRoleIDByRoleName(List<String> roleName);
	
	public List<Country> serachOnSite();
	
	public CapgUserRole findCapgUserRoleName(String fullName);
	public int addCapgUserRoles(CapgUserRole capgUserRole);
	public int deleteCapgUserRole(CapgUserRole capgUserRole);
	public int updateCapgUserRoles(CapgUserRole capgUserRole);
}
