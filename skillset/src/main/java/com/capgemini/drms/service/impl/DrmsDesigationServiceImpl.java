package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsDesigationDao;
import com.capgemini.drms.model.DrmsDesigation;
import com.capgemini.drms.service.DrmsDesigationService;

@Service(value="DrmsDesigationService")
public class DrmsDesigationServiceImpl implements DrmsDesigationService {
	@Autowired
	private DrmsDesigationDao drmsDesigationDao;

	public List<DrmsDesigation> searchAllDrmsDesigation() {
		return drmsDesigationDao.searchAllDrmsDesigation();
	}

}
