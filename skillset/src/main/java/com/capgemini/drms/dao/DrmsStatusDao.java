package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsStatus;

@Repository
public interface DrmsStatusDao {
	public List<DrmsStatus> searchStatusAll();
	public int updateDrmsStatus(DrmsStatus drmsStatus);
	public int insertDrmsStatus(DrmsStatus drmsStatus);  
}
