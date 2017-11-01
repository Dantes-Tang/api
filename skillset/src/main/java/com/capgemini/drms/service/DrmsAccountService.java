package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.drms.model.DrmsAccount;

/**
 * @ClassName: DrmsAccountService
 * @Description: TODO
 * @author winson luo
 * @date Feb 24, 2017 5:27:03 PM
 * 
 */
@Service
public interface DrmsAccountService {
	public List<DrmsAccount> getAll();

	public int updateDrmsAccount(DrmsAccount drmsAccount);

	public int insertDrmsAccount(DrmsAccount drmsAccount);

	public DrmsAccount getDrmsAccountByName(String accountName);
}
