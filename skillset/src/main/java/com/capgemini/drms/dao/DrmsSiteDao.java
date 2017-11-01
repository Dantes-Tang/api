package com.capgemini.drms.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.drms.model.DrmsSite;
@Repository
public interface DrmsSiteDao {
	   public int updateDrmsSite(DrmsSite drmsSite);
	   public int insertDrmsSite(DrmsSite drmsSite);       
	   public List<DrmsSite> searchDrmsSiteAll();
	   public List<DrmsSite> searchDrmsSiteById(@RequestParam int siteId);
	   
	   /** 
	* @author : winson luo 
	* @version ：Feb 24, 2017 6:18:12 PM
	* @Title: getDrmsSiteByname 
	* @Description: TODO 
	* @param @param siteName
	* @param @return    
	* @return DrmsSite   
	* @throws 
	*/
	public DrmsSite getDrmsSiteByname(String siteName);
}
