package com.capgemini.drms.service.impl;

import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsCapabilityDao;
import com.capgemini.drms.dao.DrmsDemandDao;
import com.capgemini.drms.dao.DrmsResourceDao;
import com.capgemini.drms.dao.DrmsSiteDao;
import com.capgemini.drms.dao.SkillMatrixDao;
import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsDemandStatus;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.service.DrmsDemandService;
import com.capgemini.drms.util.ExportExcel;

@Service(value = "DrmsDemandService")
public class DrmsDemandServiceImpl implements DrmsDemandService {

	@Autowired
	private DrmsDemandDao drmsDemandDao;
	@Autowired
	private DrmsResourceDao drmsResourceDao;
	@Autowired
	private SkillMatrixDao skillMatrixDao;
	@Autowired
	private DrmsCapabilityDao drmsCapabilityDao;
	@Autowired
	private DrmsSiteDao drmsSiteDao;

	public int updateDrmsDemand(DrmsDemand drmsDemand) {
		return drmsDemandDao.updateDrmsDemand(drmsDemand);
	}

	public int insertDrmsDemand(DrmsDemand drmsDemand) {
		String showId = drmsDemand.getDmdShowId();
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		String capName = drmsDemand.getDrmsCapability().getCapName().trim();
		DrmsCapability drmsCapability = drmsCapabilityDao.getDrmsCapabilityByname(capName);
		temp=drmsCapability.getCapShortName();
		int count = drmsDemandDao.countDemandOfOpp(drmsDemand.getDrmsOpp());
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMaximumIntegerDigits(2);
		nf.setMinimumIntegerDigits(2);
		String siteName=drmsDemand.getDrmsSite().getSiteName();
		String siteshortName= drmsSiteDao.getDrmsSiteByname(siteName).getSiteshortName();
		stringBuffer.append(showId)
					.append("-")
					.append(temp)
					.append(nf.format(count + 1))
					.append("-")
					.append(siteshortName);
		drmsDemand.setDmdShowId(stringBuffer.toString());
		DrmsDemandStatus drmsDemandStatus = new DrmsDemandStatus();
		drmsDemandStatus.setDmdStatusId(1);
		drmsDemandStatus.setDmdStatusName("New");
		drmsDemand.setDrmsDemandStatus(drmsDemandStatus);
		return drmsDemandDao.insertDrmsDemand(drmsDemand);
	}

	public List<DrmsDemand> searchDrmsDemandById(int oppIds) {
		return drmsDemandDao.searchDrmsDemandById(oppIds);
	}

	public List<DrmsDemand> searchDrmsDemandTBD() {
		return drmsDemandDao.searchDrmsDemandTBD();
	}

	public List<DrmsDemand> searchAllDrmsDemand() {
		return drmsDemandDao.searchAllDrmsDemand();
	}

	/*
	 * @SuppressWarnings("null") public Map<String, Map<String,
	 * List<SkillMatrix>>> matchedResource(int dmdId) { boolean flagOneResource
	 * = true; DrmsDemand drmsDemandTBD =
	 * drmsDemandDao.searchDrmsDemandTBDByID(dmdId); List<DrmsDemand>
	 * allDrmsResource = drmsDemandDao.matchedDemands(); Map<String, Map<String,
	 * List<SkillMatrix>>> allReourceMap = new HashMap<String,
	 * Map<String,List<SkillMatrix>>>();
	 * 
	 * Date startTime = drmsDemandTBD.getStartDate(); Date endTime =
	 * drmsDemandTBD.getEndDate(); for (int i = 0; i < allDrmsResource.size();
	 * i++) { int resourceId = allDrmsResource.get(i).getDrmsResource()
	 * .getResourceId(); List<DrmsDemand> drmsDemandOne = drmsDemandDao
	 * .searchDemands(resourceId); for (DrmsDemand drmsDemandNotTBD :
	 * drmsDemandOne) { Date startTimeNotTBD = drmsDemandNotTBD.getStartDate();
	 * Date endTimeNotTBD = drmsDemandNotTBD.getEndDate(); if
	 * (startTimeNotTBD.after(endTime) || endTimeNotTBD.before(startTime)) { }
	 * else { flagOneResource = false; break; } } if (flagOneResource) { String
	 * tempNameString = drmsResourceDao.searchName(resourceId);// Map<String,
	 * List<SkillMatrix>> matchedSkillMatrixs = new HashMap<String,
	 * List<SkillMatrix>>();
	 * 
	 * matchedSkillMatrixs.put(tempNameString,
	 * skillMatrixDao.searchSkillMatrixByName(tempNameString));
	 * 
	 * if(allReourceMap.containsKey(resourceId)){ }else {
	 * allReourceMap.put(resourceId+"", matchedSkillMatrixs); }
	 * 
	 * } else { flagOneResource = true; } } return allReourceMap;
	 * 
	 * }
	 */

	@SuppressWarnings("null")
	public List<Map<String, Object>> matchedResource(int dmdId) {
		boolean flagOneResource = true;
		DrmsDemand drmsDemandTBD = drmsDemandDao.searchDrmsDemandTBDByID(dmdId);
		List<DrmsDemand> allDrmsResource = drmsDemandDao.matchedDemands();
		List<Map<String, Object>> allMatchedResource = new ArrayList<Map<String, Object>>();

		Date startTime = drmsDemandTBD.getStartDate();
		Date endTime = drmsDemandTBD.getEndDate();
		for (int i = 0; i < allDrmsResource.size(); i++) {
			int resourceId = allDrmsResource.get(i).getDrmsResource()
					.getResourceId();
			List<DrmsDemand> drmsDemandOne = drmsDemandDao
					.searchDemands(resourceId);
			for (DrmsDemand drmsDemandNotTBD : drmsDemandOne) {
				Date startTimeNotTBD = drmsDemandNotTBD.getStartDate();
				Date endTimeNotTBD = drmsDemandNotTBD.getEndDate();
				if (startTimeNotTBD.after(endTime)
						|| endTimeNotTBD.before(startTime)) {
				} else {
					flagOneResource = false;
					break;
				}
			}
			if (flagOneResource) {
				String tempNameString = drmsResourceDao.searchName(resourceId);//

				Map<String, Object> matchedSkillMatrixs = new HashMap<String, Object>();
				matchedSkillMatrixs = new HashMap<String, Object>();
				matchedSkillMatrixs.put("resourceId", resourceId);
				matchedSkillMatrixs.put("resourceName", tempNameString);
				matchedSkillMatrixs.put("skills",
						skillMatrixDao.searchSkillMatrixByName(tempNameString));

				allMatchedResource.add(matchedSkillMatrixs);
			} else {
				flagOneResource = true;
			}
		}
		return allMatchedResource;

	}

	@Override
	public List<List<SkillMatrix>> notMatchedResource(int dmdId) {
		boolean flagOneResource = true;
		DrmsDemand drmsDemandTBD = drmsDemandDao.searchDrmsDemandTBDByID(dmdId);
		List<DrmsDemand> allDrmsResource = drmsDemandDao.matchedDemands();
		List<List<SkillMatrix>> notMuchSkillMatrixs = new ArrayList<List<SkillMatrix>>();

		Date startTime = drmsDemandTBD.getStartDate();
		Date endTime = drmsDemandTBD.getEndDate();
		for (int i = 0; i < allDrmsResource.size(); i++) {
			int resourceId = allDrmsResource.get(i).getDrmsResource()
					.getResourceId();
			List<DrmsDemand> drmsDemandOne = drmsDemandDao
					.searchDemands(resourceId);
			for (DrmsDemand drmsDemandNotTBD : drmsDemandOne) {
				Date startTimeNotTBD = drmsDemandNotTBD.getStartDate();
				Date endTimeNotTBD = drmsDemandNotTBD.getEndDate();
				if (startTimeNotTBD.after(endTime)
						|| endTimeNotTBD.before(startTime)) {

				} else {
					flagOneResource = false;
					break;
				}
			}
			if (flagOneResource) {
			} else {
				String tempNameString = drmsResourceDao.searchName(resourceId);
				if (!"TBD".equals(tempNameString)) {
					notMuchSkillMatrixs.add(skillMatrixDao
							.searchSkillMatrixByName(tempNameString));
					flagOneResource = true;
				} else {
				}
			}
		}
		return notMuchSkillMatrixs;

	}

	public void exportExcel(String fileName, String headName,
			String[] columsName, OutputStream out) {

		ExportExcel exportxcel = new ExportExcel();
		exportxcel.export(this.searchAllDrmsDemand(), fileName, headName,
				columsName, out);
	}

	/*
	 * @Override public List<DrmsDemand> updateDemandResourceId(String
	 * resourceName) { boolean flag = false; List<DrmsDemand> lists = new
	 * ArrayList<DrmsDemand>(); // 获取所有标记为TBD的demand List<DrmsDemand>
	 * searchAllDemandsTBD = drmsDemandDao.searchDrmsDemandTBD();
	 * List<DrmsDemand> searchAllDemandsNotMatch =
	 * drmsDemandDao.matchedDemands(); for (int i = 0; i <
	 * searchAllDemandsTBD.size(); i++) { // 获取所有标记为TBD的demand的id int demandId =
	 * searchAllDemandsTBD.get(i).getDmdId(); // 根据id查询需所有的demand DrmsDemand
	 * searchDemandsTBD = drmsDemandDao.searchDrmsDemandTBDByID(demandId); //
	 * 获取需要替换的resourceID int resourceId =
	 * drmsResourceDao.searchResourceId(resourceName).getResourceId(); Date
	 * startTime = searchDemandsTBD.getStartDate(); Date endTime =
	 * searchDemandsTBD.getEndDate(); // 获取没有match的demand的开始结束时间 for (DrmsDemand
	 * demandsNotMatch : searchAllDemandsNotMatch) { Date startTimeNotMatch =
	 * demandsNotMatch.getStartDate(); Date endTimeNotMatch =
	 * demandsNotMatch.getEndDate(); if (!startTimeNotMatch.after(endTime) ||
	 * !endTimeNotMatch.before(startTime)) { flag = true; } else{ flag = false;
	 * } } if(flag){ // 更新resourceId int items =
	 * drmsDemandDao.updateResourceId(demandId, resourceId,); if(items>0){
	 * lists.add(searchDemandsTBD); } }else{
	 * 
	 * }
	 * 
	 * } return lists; }
	 */

	@Override
	public int updateMacthedResourceId(int dmdId, int resourceId, int capId) {
		// TODO Auto-generated method stub

		return drmsDemandDao.updateResourceId(dmdId, resourceId, capId);

	}

	@Override
	public List<DrmsDemand> searchAllDemands() {
		return drmsDemandDao.searchAllDemands();
	}

	@Override
	public DrmsDemand searchDrmsDemand(int dmdId) {
		// TODO Auto-generated method stub
		
	    
	    
	    return drmsDemandDao.searchDrmsDemand(dmdId);
	}

	@Override
	public List<DrmsDemand> updateDemandResourceId(String recourceName) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<DrmsDemand> searchDemandsByStatus(Integer status)
    {
        // TODO Auto-generated method stub
       List<DrmsDemand> drmsDemands = null;
        if(status==0){
            
           drmsDemands = drmsDemandDao.searchDrmsDemandsByStatusAll();
        }
        
        if(status ==1){
            drmsDemands = drmsDemandDao.searchDrmsDemandsByStatus();
        }
        return drmsDemands;
    }
    
}