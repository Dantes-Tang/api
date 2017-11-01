package com.capgemini.drms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsOpp;


@Repository
public interface DrmsDemandDao {
	
	public int updateDrmsDemand(DrmsDemand drmsDemand);

	public int insertDrmsDemand(DrmsDemand drmsDemand);

	public List<DrmsDemand> searchDrmsDemandById(int oppId);

	public List<DrmsDemand> searchDrmsDemandTBD();
	
	public List<DrmsDemand> searchAllDrmsDemand();

	public DrmsDemand searchDrmsDemandTBDByID(int dmdId);

	public List<DrmsDemand> searchDemands(int resourceId);

	public List<DrmsDemand> matchedDemands();

	public int countDemandOfOpp(DrmsOpp drmsOpp);

	public int updateResourceId(@Param("dmdId") int dmdId,
			@Param("resourceId") int resourceId,@Param("capId") int capId);

	public void updateMacthedResourceId(int dmdId, int resourceId);
	public List<DrmsDemand> searchAllDemands();
	public DrmsDemand searchDrmsDemand(int dmdId);
	public List<DrmsDemand> searchDrmsDemandsByStatusAll();
	public List<DrmsDemand> searchDrmsDemandsByStatus();
	
	
}
