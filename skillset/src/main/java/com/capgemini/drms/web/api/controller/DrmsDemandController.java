package com.capgemini.drms.web.api.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.service.DrmsDemandService;
import com.sun.mail.imap.protocol.ID;


@Controller
@RequestMapping("/api/DrmsDemand")
public class DrmsDemandController {

	@Autowired
	private DrmsDemandService drmsDemandService;
	@RequestMapping(value = "/updateOrAdd", method = RequestMethod.POST)
	public @ResponseBody List<Boolean> updateOrAdd(@RequestBody List<DrmsDemand> drmsDemands) {
		List<Boolean> list = new LinkedList<Boolean>();
		for(DrmsDemand drmsDemand:drmsDemands){
			if(drmsDemand.getDmdId()==0){
				if (drmsDemandService.insertDrmsDemand(drmsDemand) > 0){
						list.add(true);
					}else{
						list.add(false);
					}
			}else{
				if (drmsDemandService.updateDrmsDemand(drmsDemand) > 0){
					list.add(true);
				}else{
					list.add(false);
				}
			}
		}
		return list;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody List<DrmsDemand> searchDrmsDemandBySearcher(@RequestParam int oppId) {
		return drmsDemandService.searchDrmsDemandById(oppId);
	}
	@RequestMapping(value = "/searchTBD",method = RequestMethod.POST)
	public @ResponseBody List<DrmsDemand> searchDrmsDemandBySearcherTBD() {
		return drmsDemandService.searchDrmsDemandTBD();
	}
	@RequestMapping(value="/matchedResource", method = RequestMethod.POST)
	public  @ResponseBody List<Map<String, Object>> matchedResource(@RequestParam int dmdId){
		List<Map<String, Object>> skillMatrixs =  drmsDemandService.matchedResource(dmdId);
		
		return skillMatrixs;
	}
//    @RequestMapping(value="/updateResourceId", method = RequestMethod.POST)
//	public @ResponseBody List<DrmsDemand> updateResourceId(@RequestParam int dmdId,@RequestParam int resourceId){
//    	List<DrmsDemand> updateResourceId = drmsDemandService.updateDemandResourceId(dmdId, resourceId);
//    	return updateResourceId;
//    }
	@RequestMapping(value = "/exportExcel",method = RequestMethod.GET)
	public void exportExcel(HttpServletRequest req, HttpServletResponse resp){
		 
		 String fileName = "Demand.xls";
		 String[] columsName={"Demand NO","Opportunity","Resource","Site","Desigation","Alternative Desigation","Project Name","Project Position","Assignment Capobility", "Capability","Allocation Type","Allocation Ratio","Start Date","End Date"};
		 String headName="DEMAND";
		
		 try {
		
			 OutputStream out=resp.getOutputStream();
			 resp.setCharacterEncoding("UTF-8");
			 resp.setContentType("application/x-download");
			 resp.setHeader("Content-Disposition", "attachment;filename="+ fileName);
			 drmsDemandService.exportExcel(fileName,headName,columsName,out);
		 } catch (IOException e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(value = "/updateMatchedResourceId" , method = RequestMethod.POST)
	public @ResponseBody boolean updateMacthedResourceId(@RequestParam("dmdId") int dmdId, @RequestParam("resourceId") int resourceId,@RequestParam("capId") int capId ){
	   if( drmsDemandService.updateMacthedResourceId(dmdId, resourceId,capId) >0) return true;
	   return false;
	
		
	}
	@RequestMapping(value = "/reloadPage", method = RequestMethod.POST)
	public @ResponseBody DrmsDemand searchDemand(@RequestParam("dmdId") int dmdId){
	    return drmsDemandService.searchDrmsDemand(dmdId);
	    
	}
	@RequestMapping(value = "/searchByStatus",method = RequestMethod.POST)
	public @ResponseBody List<DrmsDemand> searchDemandByDemandStatus(@RequestParam("status")Integer status){
	    
	    return drmsDemandService.searchDemandsByStatus(status);
	}
	

	
}
