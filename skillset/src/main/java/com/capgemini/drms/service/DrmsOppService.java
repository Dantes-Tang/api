package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsOpp;

@Repository
public interface DrmsOppService {
   public List<DrmsOpp> getDrmsOpp();
   public int insertDrmsOpp(DrmsOpp drmsOpp);
   public int updateDrmsOpp(DrmsOpp drmsOpp);
   // get all Opp except status is complete and close
   public List<DrmsOpp> getDrmsOppByStatus();
}
