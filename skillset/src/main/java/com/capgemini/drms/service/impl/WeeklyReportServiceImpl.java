package com.capgemini.drms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.WeeklyReportDao;
import com.capgemini.drms.model.WeeklyReport;
import com.capgemini.drms.service.WeeklyReportService;

@Service(value = "WeeklyReportService")
public class WeeklyReportServiceImpl implements WeeklyReportService {
	@Autowired
	WeeklyReportDao weeklyReportDao;

	@Override
	public List<WeeklyReport> getWeeklyReport() {

		return weeklyReportDao.getWeeklyReport();
	}

	@Override
	public List<Map<String, Double>> getSummaryDesignationReport() {
		List<Map<String, Double>> summary = new ArrayList<>();
		List<WeeklyReport> weeklyReports = getWeeklyReport();
		List<String> listDesignation = new ArrayList<>();
		for (WeeklyReport weeklyReport : weeklyReports) {
			listDesignation.add(weeklyReport.getDesignation().replaceAll(" ", ""));	
		}
		HashSet<String> h1  =   new  HashSet<String>(listDesignation); 
		listDesignation.clear(); 
		listDesignation.addAll(h1); 	
		for (String designation : listDesignation) {
			Map<String, Double> map = new HashMap<>();
			double account=0.0;
			for (WeeklyReport weeklyReport : weeklyReports) {
				if(weeklyReport.getDesignation().equals(designation))
				account++;
			}
			map.put(designation, account);
			summary.add(map);
		}
		
		return summary;
	}

	@Override
	public List<Map<String, Double>> getSummaryCapabilityReport() {
		List<Map<String, Double>> summary = new ArrayList<>();
		List<WeeklyReport> weeklyReports = getWeeklyReport();
		List<String> listCapability = new ArrayList<>();
		for (WeeklyReport weeklyReport : weeklyReports) {
			listCapability.add(weeklyReport.getCapability().replaceAll(" ", ""));
		}
		HashSet<String> h2  =   new  HashSet<String>(listCapability); 
		listCapability.clear(); 
		listCapability.addAll(h2);
		
		for (String capability : listCapability) {
			Map<String, Double> map = new HashMap<>();
			double account=0.0;
			for (WeeklyReport weeklyReport : weeklyReports) {
				if(weeklyReport.getCapability().equals(capability))
				account++;
			}
			map.put(capability, account);
			summary.add(map);
		}
		
		return summary;
	}

}
