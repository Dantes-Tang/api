package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.AppDictionaryDao;
import com.capgemini.drms.model.AppDictionary;
import com.capgemini.drms.model.AppDictionarySearchModel;
import com.capgemini.drms.service.AppDictionaryService;
   @Service(value = "AppDictionaryService")
public class AppDictionaryServiceImpl implements AppDictionaryService {
    @Autowired
    private  AppDictionaryDao  appDictionaryDao;
	
		
//	public List<AppDictionary> searchAppDictionaryBy(String name) {
//		
//		return appDictionaryDao.searchAppDictionaryBy(name);
//	}

	public int insertDictionary(AppDictionary dictionary) {
	  
		return appDictionaryDao.insertAppDictionary(dictionary);
		
	}

	public int deleteAppDictionary(int id) {
		return appDictionaryDao.deleteAppDictionary(id);
		
	}

	public int updateAppDictionary(AppDictionary appDictionary) {
		return appDictionaryDao.updateAppDictionary(appDictionary);
	}

	
	public List<AppDictionary> searchAppDictionaryBySearcher(
			AppDictionarySearchModel searcher) {
		
		return  appDictionaryDao.searchAppDictionaryBySearcher(searcher);
	}

	



	
  }
