package com.capgemini.drms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsSkillFlexibilityDao;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.service.DrmsSkillFlexibilityService;
@Service(value="drmsSkillFlexibilityService")
public class DrmsSkillFlexibilityServiceImpl implements DrmsSkillFlexibilityService{
	@Autowired
	private DrmsSkillFlexibilityDao drmsSkillFlexibilityDao;
	/**
	 * @author hongwu
	 * @return User's Information
	 */
public List<Map<String, String>> findUserInformation(){
	return drmsSkillFlexibilityDao.findUserInformation();	
}
public List<String> findFullName(){
	return drmsSkillFlexibilityDao.findFullName();
}
public List<SkillMatrix> findSkillMatrix(String fullName){
	return drmsSkillFlexibilityDao.findSkillMatrix(fullName);
}
public List<Flexibility> findFlexibility(String fullName){
	return drmsSkillFlexibilityDao.findFlexibility(fullName);
}
}
