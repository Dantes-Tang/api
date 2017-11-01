package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsDesigation;

@Repository
public interface DrmsDesigationService {
	
	
	public List<DrmsDesigation> searchAllDrmsDesigation();
}
