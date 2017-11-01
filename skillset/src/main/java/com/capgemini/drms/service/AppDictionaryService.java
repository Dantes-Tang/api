package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.AppDictionary;
import com.capgemini.drms.model.AppDictionarySearchModel;

@Repository
public interface AppDictionaryService {
	
	public int insertDictionary(AppDictionary appDictionary);
	
//	public List<AppDictionary> searchAppDictionaryBy(String name);
	
	public int updateAppDictionary(AppDictionary appDictionary);
	
	public int deleteAppDictionary(int id);

	public List<AppDictionary> searchAppDictionaryBySearcher(AppDictionarySearchModel searcher);
}
