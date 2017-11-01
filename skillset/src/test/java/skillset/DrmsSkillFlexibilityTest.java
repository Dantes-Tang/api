package skillset;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.model.SkillMatrixFlexibility;
import com.capgemini.drms.service.DrmsSkillFlexibilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsSkillFlexibilityTest {
	@Autowired 
	private DrmsSkillFlexibilityService drmsSkillFlexibilityService;
	
	@Test
	public void test1(){
		List<Map<String,String>> userInformation=drmsSkillFlexibilityService.findUserInformation();
		for (int i = 0; i < userInformation.size(); i++) {
			Map<String, String> map=userInformation.get(i);
			System.out.println();
			/*System.out.println(map);*/
			for (Map.Entry<String, String> e: map.entrySet()) {
				System.out.print(e.getKey()+":"+e.getValue()+" ");
			}
		}
	}
	@Test
	public void test2(){
		List<String> findFullName=drmsSkillFlexibilityService.findFullName();
		System.out.println();
		System.out.println(findFullName.toString());
		System.out.println();
		List<String> fullNameList=drmsSkillFlexibilityService.findFullName();
		List<SkillMatrixFlexibility>skillMatrixFlexibilities=new ArrayList<>();
		for (int i = 0; i <fullNameList.size(); i++) {
			String  string=fullNameList.get(i);
			SkillMatrixFlexibility skillMatrixFlexibility=new SkillMatrixFlexibility();
			skillMatrixFlexibility.setFullName(string);
			skillMatrixFlexibility.setFlexibility(drmsSkillFlexibilityService.findFlexibility(skillMatrixFlexibility.getFullName()));
			skillMatrixFlexibility.setSkillMatrix(drmsSkillFlexibilityService.findSkillMatrix(skillMatrixFlexibility.getFullName()));
			skillMatrixFlexibilities.add(skillMatrixFlexibility);
			System.out.println();
			System.out.println(skillMatrixFlexibilities.toString());
			System.out.println();
		}
		
	}
}
