package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.Category;
import com.capgemini.drms.model.SkillMatrix;

@Repository
public interface SkillMatrixService {

	public List<Category> getCategorys();

	public void updateSkillMatrix(SkillMatrix skillMatrix);

	public List<SkillMatrix> loadSkillMatrixByUsername(String username);

	public void insertSkillMatrix(SkillMatrix skillMatrix);

	public void insertSkillMatrix(List<SkillMatrix> skillMatrixes);

	public void deleteSkillMatrix(String username);

	public CapgUser loadCapgUser(CapgUser capgUser);

	public List<SkillMatrix> searchSkillMatrixByName(String name);
	

}
