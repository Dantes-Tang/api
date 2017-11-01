package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsDemandStatus;

@Repository
public interface DrmsDemandStatusService {
	public List<DrmsDemandStatus> searchDemandStatuses();

}
