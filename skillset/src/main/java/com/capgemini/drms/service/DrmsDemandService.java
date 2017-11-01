package com.capgemini.drms.service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.model.SkillMatrix;

@Repository
public interface DrmsDemandService
{

    public int updateDrmsDemand(DrmsDemand drmsDemand);

    public int insertDrmsDemand(DrmsDemand drmsDemand);

    public List<DrmsDemand> searchDrmsDemandById(int oppId);

    public List<DrmsDemand> searchDrmsDemandTBD();

    public List<Map<String, Object>> matchedResource(int dmdId);

    public List<List<SkillMatrix>> notMatchedResource(int dmdId);

    public void exportExcel(String fileName, String headName, String[] columsName, OutputStream out);

    public List<DrmsDemand> updateDemandResourceId(String recourceName);

    public int updateMacthedResourceId(int dmdId, int resourceId, int capId);

    public List<DrmsDemand> searchAllDemands();

    public DrmsDemand searchDrmsDemand(int dmdId);

    public List<DrmsDemand> searchDemandsByStatus(Integer status);

}


	
