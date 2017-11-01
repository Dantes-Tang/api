package com.capgemini.drms.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
@Repository
public interface DrmsAllUrlAndRoleDao {
	public  List<String> findAllUrl();
	public  List<String> findAllRoleByUrl(String url);
	

}
