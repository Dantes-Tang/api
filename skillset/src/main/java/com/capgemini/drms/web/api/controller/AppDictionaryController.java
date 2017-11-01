package com.capgemini.drms.web.api.controller;

import java.util.List;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.AppDictionary;
import com.capgemini.drms.model.AppDictionarySearchModel;
import com.capgemini.drms.service.AppDictionaryService;

 @Controller
 @RequestMapping("/api/AppDictionary")
public class AppDictionaryController  {
	 private static final Log logger= LogFactory.getLog(AppDictionaryController.class);
	@Autowired
	private AppDictionaryService appDictionaryService;
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public @ResponseBody boolean  add(@RequestBody AppDictionary appDictionary,HttpServletRequest request){
		if(appDictionaryService.insertDictionary(appDictionary) > 0) return true;
			
		return false;
	}
	
	@RequestMapping(value="/update",method =RequestMethod.POST)
   public @ResponseBody boolean update(@RequestBody AppDictionary appDictionary,HttpServletRequest request)
   {
		if(appDictionaryService.updateAppDictionary(appDictionary) > 0) return true;
		
	    return false;
   }
	@RequestMapping(value="/delete",method = RequestMethod.GET)
   public @ResponseBody  boolean deleteAppDictionary(@RequestParam int id)
	{ 
		if(appDictionaryService.deleteAppDictionary(id) > 0) return true ;
		return false;
	}
	
	
//	@RequestMapping(value="/seach",method = RequestMethod.POST)
//	public @ResponseBody List<AppDictionary> searchAppDictionaryByName(@RequestBody String name,HttpServletRequest request)
//	{
//	
//	 if(name.equals("")){
//		 name = null;
//	 }
//	 List<AppDictionary> list =appDictionaryService.searchAppDictionaryBy(name);
//	   return list;
//	}

	
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public @ResponseBody List<AppDictionary> searchAppDictionaryBySearcher(@RequestBody AppDictionarySearchModel searcher)
	{
	   return appDictionaryService.searchAppDictionaryBySearcher(searcher);
	   
	}

}
