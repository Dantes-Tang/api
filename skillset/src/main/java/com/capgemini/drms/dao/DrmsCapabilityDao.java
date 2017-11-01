package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsCapability;

@Repository
public interface DrmsCapabilityDao {
	public int updateDrmsCapability(DrmsCapability drmsCapability);

	public int insertDrmsCapability(DrmsCapability drmsCapability);

	public List<DrmsCapability> searchDrmsCapabilityAll();

	/**
	 * @author : winson luo
	 * @version ：Feb 24, 2017 6:03:53 PM
	 * @Title: getDrmsCapabilityByname
	 * @Description: TODO
	 * @param @param capabilityByname
	 * @param @return
	 * @return DrmsCapability
	 * @throws
	 */
	public DrmsCapability getDrmsCapabilityByname(String capName);

}