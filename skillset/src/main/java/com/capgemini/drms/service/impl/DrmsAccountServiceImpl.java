package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsAccountDao;
import com.capgemini.drms.model.DrmsAccount;
import com.capgemini.drms.service.DrmsAccountService;

/**
 * @ClassName: DrmsAccountServiceImpl
 * @Description: TODO
 * @author winson luo
 * @date Feb 24, 2017 5:27:18 PM
 * 
 */
@Service
public class DrmsAccountServiceImpl implements DrmsAccountService {
	@Autowired
	private DrmsAccountDao drmsAccountDao;

	@Override
	public List<DrmsAccount> getAll() {
		return drmsAccountDao.getAll();
	}

	@Override
	public int updateDrmsAccount(DrmsAccount drmsAccount) {

		return drmsAccountDao.updateDrmsAccount(drmsAccount);
	}

	@Override
	public int insertDrmsAccount(DrmsAccount drmsAccount) {
		return drmsAccountDao.insertDrmsAccount(drmsAccount);
	}

	@Override
	public DrmsAccount getDrmsAccountByName(String accountName) {
		return drmsAccountDao.getDrmsAccountByName(accountName);
	}

}
