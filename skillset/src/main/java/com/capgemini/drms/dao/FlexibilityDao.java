package com.capgemini.drms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.Country;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SearchModel;

/**
 * 
 * @author calvye
 *
 */
@Repository
public interface FlexibilityDao {

	public List<CapgUser> searchCapgUser(SearchModel searchModel);

	/**
	 * Load the Country by Parent Id
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Country> loadCountry(Integer parentId);

	/**
	 * Update the skillmatrix
	 * 
	 * @param flexibility
	 */
	public void updateFlexibility(Flexibility flexibility);

	/**
	 * 
	 * @param username
	 * @return
	 */
	public List<Flexibility> loadFlexibilityByUsername(String username);

	public void insertFlexibility(Flexibility flexibility);

	public void deleteFlexibility(String username);
	/**
	 *functional description:
	 *@param
	 *@retrun
	 *@throw
	 *@see  
	 * @param userName
	 * @return
	 */
	public List<Flexibility> searchCountryByUserName(String userName);
	
	/**
	 *functional description:
	 *@param
	 *@throw
	 *@see  
	 * @param duration
	 * @param id
	 * @return
	 */
	public int updateDuration(@Param("duration")String duration,@Param("id")long id);
	/**
	 *functional description:
	 *@param
	 *@retrun
	 *@throw
	 *@see  
	 * @return
	 */
	public List<Country> searchOnSite();
	

}
