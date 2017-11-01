package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.LdapUserDao;
import com.capgemini.drms.dao.SkillMatrixDao;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.Category;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.service.SkillMatrixService;

@Service(value = "skillMatrixService")
public class SkillMatrixServiceImpl implements SkillMatrixService {

	@Autowired
	private SkillMatrixDao skillMatrixDao;

	@Autowired
	private LdapUserDao ldapUserDao;

	public List<Category> getCategorys() {
		return skillMatrixDao.loadCategory(0);
	}

	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		skillMatrixDao.updateSkillMatrix(skillMatrix);
	}

	public List<SkillMatrix> loadSkillMatrixByUsername(String username) {
		return skillMatrixDao.loadSkillMatrixByUsername(username);
	}

	public void insertSkillMatrix(SkillMatrix skillMatrix) {
		skillMatrixDao.insertSkillMatrix(skillMatrix);
	}

	public void insertSkillMatrix(List<SkillMatrix> skillMatrixes) {
		if (skillMatrixes != null && skillMatrixes.size() > 0) {
			skillMatrixDao
					.deleteSkillMatrix(skillMatrixes.get(0).getUsername());
			for (SkillMatrix skill : skillMatrixes) {
				insertSkillMatrix(skill);
			}
		}
	}

	public void deleteSkillMatrix(String username) {
		skillMatrixDao.deleteSkillMatrix(username);
	}

	public CapgUser loadCapgUser(CapgUser capgUser) {
		return ldapUserDao.loadCapgUserFromLdap(capgUser.getUserName());
	}

	public List<SkillMatrix> searchSkillMatrixByName(String name) {
		// TODO Auto-generated method stub
		return skillMatrixDao.searchSkillMatrixByName(name);
	}

}
