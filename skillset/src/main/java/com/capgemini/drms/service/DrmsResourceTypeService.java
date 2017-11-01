package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsResourceType;

/**
 * functional description： XXXXXX
 * 
 * @author dantang @capgemini.com
 * @created Feb 21, 201710:24:57 AM
 * @date Feb 21, 201710:24:57 AM
 */
@Repository
public interface DrmsResourceTypeService {
	public List<DrmsResourceType> searchAllDrmsResourceTypes();
}
