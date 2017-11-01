package com.capgemini.drms.dao;

import java.util.List;




import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.Category;
import com.capgemini.drms.model.SkillMatrix;

/**
 * 
 * @author calvye
 *
 */
@Repository
public interface SkillMatrixDao {
	
		/**
		 * Load the Category by Parent Id
		 * @param parentId
		 * @return
		 */
		public List<Category> loadCategory(Integer parentId);
		
		/**
		 * Update the skillmatrix
		 * @param skillMatrix
		 */
		public void updateSkillMatrix(SkillMatrix skillMatrix);
		
		/**
		 * 
		 * @param username
		 * @return
		 */
		public List<SkillMatrix> loadSkillMatrixByUsername(String username);
		
		public void insertSkillMatrix(SkillMatrix skillMatrix);
		
		public void deleteSkillMatrix(String username);


		public List<SkillMatrix> searchSkillMatrixByName(String name);
		
}
