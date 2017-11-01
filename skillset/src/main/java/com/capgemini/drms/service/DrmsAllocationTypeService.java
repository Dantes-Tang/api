package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsAllocationType;

/**
 * @author dantang
 *
 */
@Repository
public interface DrmsAllocationTypeService {
	public int updateDrmsAllocationType(DrmsAllocationType drmsAllocationType);

	public int insertDrmsAllocationType(DrmsAllocationType drmsAllocationType);

	public List<DrmsAllocationType> searchAllocationTypeAll();
}
