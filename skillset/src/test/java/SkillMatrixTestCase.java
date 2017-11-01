

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.dao.SkillMatrixDao;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.Category;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.service.SkillMatrixService;
import com.capgemini.drms.web.api.controller.SkillMatrixController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class SkillMatrixTestCase {

	@Autowired
	private SkillMatrixService skillMatrixService;
	@Test
	public void getCategorys() {

		List<Category> categorys = skillMatrixService.getCategorys();
		System.out.println("----------------------------------------------------"+categorys.size());
		
	}
	

	
	@Test
	public void updateorAddSkillMatrix() {
		SkillMatrix skillMatrix = new SkillMatrix();		
		skillMatrix.setExperience("25");
		skillMatrix.setUsername("healiu");
		skillMatrix.setFullName("Ting Liu");
		skillMatrix.setSkill("COBOL");
		skillMatrix.setLevel("mdeio");
		skillMatrixService.updateSkillMatrix(skillMatrix);
	}

	@Test
	public void loadSkillMatrixByUsername() {
		skillMatrixService.loadSkillMatrixByUsername("calvye");
	}

	@Test
	public void insertSkillMatrix() {
		SkillMatrix skillMatrix = new SkillMatrix();
		skillMatrix.setExperience("25");
		skillMatrix.setUsername("healiu");
		skillMatrix.setSkill("java");
		skillMatrix.setFullName("Ting Liu");
		skillMatrix.setLevel("mdeio");
		skillMatrixService.insertSkillMatrix(skillMatrix);
	}
	
	@Test
	public void deleteSkillMatrix() {
		skillMatrixService.deleteSkillMatrix("calvye");
	}
	
	@Test
	public void getLdapUser() {
		CapgUser capgUser = new CapgUser();
		capgUser.setUserName("calvye");

		capgUser = skillMatrixService.loadCapgUser(capgUser);
		System.out.println ("------------------"+capgUser.getFullName());
	}
	@Test
	public void searchSkillMatrixsByname(){
		List<SkillMatrix> skillMatrixs = skillMatrixService.searchSkillMatrixByName("Winnie Qi");
		for (SkillMatrix skillMatrix : skillMatrixs) {
			System.out.println(skillMatrix.getSkill());
		}
	}

	
}
