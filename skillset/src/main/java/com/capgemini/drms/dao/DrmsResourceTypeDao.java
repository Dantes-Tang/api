package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsResourceType;

/**
 *functional description： XXXXXX
 * @author dantang @capgemini.com
 * @created Feb 21, 201710:25:01 AM
 * @date Feb 21, 201710:25:01 AM	
 */
@Repository
public interface DrmsResourceTypeDao {
	public List<DrmsResourceType> searchAllResourceType();
}
