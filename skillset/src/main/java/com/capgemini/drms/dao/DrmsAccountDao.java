package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsAccount;


/**
 * @ClassName: DrmsAccountDao
 * @Description: TODO
 * @author winson luo
 * @date Feb 24, 2017 5:23:12 PM
 * 
 */
@Repository
public interface DrmsAccountDao {
	public List<DrmsAccount> getAll();

	public int updateDrmsAccount(DrmsAccount drmsAccount);

	public int insertDrmsAccount(DrmsAccount drmsAccount);

	public DrmsAccount getDrmsAccountByName(String accountName);
}
