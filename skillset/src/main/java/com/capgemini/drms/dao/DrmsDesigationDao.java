package com.capgemini.drms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import com.capgemini.drms.model.DrmsDesigation;

@Repository
public interface DrmsDesigationDao {
		public int insertDesigation(DrmsDesigation drmsDesigation);
		public int updateDesigation(DrmsDesigation drmsDesigation);
		public List<DrmsDesigation> searchAllDrmsDesigation();
		public List<DrmsDesigation> searchDrmsDesigationById(@RequestParam int dsgId);
}
