package com.capgemini.drms.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.WeeklyReport;

/** 
* @ClassName: WeeklyReport 
* @Description: TODO 
* @author winson luo
* @date Mar 7, 2017 6:20:45 PM 
*  
*/
@Repository
public interface WeeklyReportService {
	public List<WeeklyReport> getWeeklyReport();
	public List<Map<String, Double>> getSummaryDesignationReport();
	public List<Map<String, Double>> getSummaryCapabilityReport();
}
