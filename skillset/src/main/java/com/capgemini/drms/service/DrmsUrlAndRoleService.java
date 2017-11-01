package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface DrmsUrlAndRoleService {
	public List<String> findAllUrl();
	public List<String> findAllRoleByUrl(String url);

}
