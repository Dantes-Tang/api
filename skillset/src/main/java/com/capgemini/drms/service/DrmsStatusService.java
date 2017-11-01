package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.drms.model.DrmsStatus;
/**
 * @author dantang
 *
 */
@Service
public interface DrmsStatusService {
	public List<DrmsStatus> searchStatusAll();
    public int updateDrmsStatus(DrmsStatus drmsStatus);   
	public int insertDrmsStatus(DrmsStatus drmsStatus);  
}
