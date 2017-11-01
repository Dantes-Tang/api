package com.capgemini.drms.web.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.WeeklyReport;
import com.capgemini.drms.service.WeeklyReportService;

@Controller
@RequestMapping("/api/reports")
public class WeeklyReportController {
	@Autowired
	private WeeklyReportService weeklyReportService;

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public @ResponseBody List<WeeklyReport> getWeeklyReport(){
	
		return weeklyReportService.getWeeklyReport();
	}
	@RequestMapping(value = "/getSummaryDesignationReport", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Double>> getSummaryDesignationReport(){
	
		return weeklyReportService.getSummaryDesignationReport();
	}
	@RequestMapping(value = "/getSummaryCapabilityReport", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Double>> getSummaryCapabilityReport(){
	
		return weeklyReportService.getSummaryCapabilityReport();
	}
	
	
}
