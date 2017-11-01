package com.capgemini.drms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SkillMatrix;
@Repository
public interface DrmsSkillFlexibilityDao {
	/**
	 * @author hongwu
	 * @return User's Information
	 */
	public List<Map<String,String>> findUserInformation();
	
	public List<String> findFullName();
	
	public List<SkillMatrix> findSkillMatrix(String fullName);
	
	public List<Flexibility> findFlexibility(String fullName);
}
