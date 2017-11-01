package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsAllocationType;

/**
 * @author dantang,create on Oct 7, 2016
 *
 */
@Repository
public interface DrmsAllocationTypeDao {
	  public int updateDrmsAllocationType(DrmsAllocationType drmsAllocationType);
	   
	   public int insertDrmsAllocationType(DrmsAllocationType drmsAllocationType);  
	   
	   public List<DrmsAllocationType> searchAllocationTypeAll();
} 
