package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsAccount;
import com.capgemini.drms.model.DrmsOpp;

@Repository
public interface DrmsOppDao {
	public List<DrmsOpp>  getDrmsOpp();
    public  int   insertDrmsOpp(DrmsOpp  drmsOpp);	
    public  int   updateDrmsOpp(DrmsOpp  drmsOpp);
    public  int   countAccountOpp(DrmsAccount drmsAccount);
    public List<DrmsOpp> getDrmsOppByStatus();
}
