package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsAllocationType;
import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.model.DrmsDesigation;
import com.capgemini.drms.model.DrmsSDAC;
import com.capgemini.drms.model.DrmsSite;

@Repository
public interface DrmsSDACService {
	public DrmsSDAC searchDrmsSDAC(String resourceNAme);
}
