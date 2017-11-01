package com.capgemini.drms.dao;

import java.util.List;

import com.capgemini.drms.model.WeeklyReport;

/** 
* @ClassName: WeeklyReportDao 
* @Description: TODO 
* @author winson luo
* @date Mar 7, 2017 6:05:03 PM 
*  
*/

public interface WeeklyReportDao {
	
	/** 
	* @author : winson luo 
	* @version ：Mar 7, 2017 6:55:58 PM
	* @Title: getWeeklyReport 
	* @Description: TODO 
	* @param @return    
	* @return List<WeeklyReport>   
	* @throws 
	*/
	public List<WeeklyReport> getWeeklyReport();

}
