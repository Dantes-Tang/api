package com.capgemini.drms.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.AppDictionary;
import com.capgemini.drms.model.AppDictionarySearchModel;


@Repository
public interface AppDictionaryDao {

	   
   public int updateAppDictionary(AppDictionary appDictionary);
   
   public int deleteAppDictionary(int id);
   
   public int insertAppDictionary(AppDictionary appDictionary);  
      
   public List<AppDictionary> searchAppDictionaryBySearcher(AppDictionarySearchModel searcher);
        
}
