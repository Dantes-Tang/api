package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsDemandStatus;

@Repository
public interface DrmsDemandStatusDao {
	public List<DrmsDemandStatus> searhcDemandStatuses();
}
