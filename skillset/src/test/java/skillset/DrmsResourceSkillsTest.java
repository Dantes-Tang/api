/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package skillset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsDemandStatusCapability;
import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsResourceSkills;
import com.capgemini.drms.service.DrmsDemandStatusCapabilityService;
import com.capgemini.drms.service.DrmsResourceSkillsService;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 13, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsResourceSkillsTest {
@Autowired
private DrmsResourceSkillsService drmsResourceSkillsService;
@Autowired
private DrmsDemandStatusCapabilityService demandStatusCapabilityService;
	@Test
	public void test1(){
		DrmsResourceSkills drmsResourceSkills=new DrmsResourceSkills();
		drmsResourceSkills=drmsResourceSkillsService.findDrmsResourceDsg("28");
		
			System.out.println();
			System.out.println();
			System.out.println(drmsResourceSkills.toString());
			System.out.println();
			System.out.println();
		
		
		
	}
	 @Test
	public void test2(){
		DrmsDemandStatusCapability demandStatusCapability=new DrmsDemandStatusCapability();
		
		int count=0;
		demandStatusCapability.setDmdID(1);
		/*demandStatusCapability.setAccountName("H");
		demandStatusCapability.setCapability("Dig");
		demandStatusCapability.setStatus("Internal Filled");*/
		List<DrmsDemandStatusCapability> list=demandStatusCapabilityService.findDrmsDemandStatusCapabilities(demandStatusCapability);
		for (DrmsDemandStatusCapability drmsDemandStatusCapability : list) {
			System.out.println();
			System.out.println(drmsDemandStatusCapability);
			System.out.println(count++);
		}
	}
	 @Test
	 public void test3(){
		 DrmsResourceSkills drmsResourceSkills5=new DrmsResourceSkills();
		 List<DrmsResourceSkills> list2=new ArrayList<DrmsResourceSkills>();
			List<DrmsResourceSkills>list1=drmsResourceSkillsService.findDrmsResourceSkills(drmsResourceSkills5);
			for (DrmsResourceSkills drmsResourceSkills2 : list1) {
				
				System.out.println("11111111111111111111111111111111111111111111111");
				System.out.println();
				System.out.println(drmsResourceSkills2.toString());
				System.out.println();
				System.out.println("11111111111111111111111111111111111111111111111");
				System.out.println();
				DrmsResourceSkills drmsResourceSkills3=drmsResourceSkillsService.findDrmsResourceDsg(drmsResourceSkills2.getResourceId());
				System.out.println();
				System.out.println("2222222222222222222222222222222222222222222222");
				System.out.println();
				System.out.println(drmsResourceSkills3.toString());
				System.out.println();
				System.out.println("22222222222222222222222222222222222222222222222");
				if (!(drmsResourceSkills3.getDesigation().isEmpty())) {
					drmsResourceSkills2.setDesigation(drmsResourceSkills3.getDesigation());
						list2.add(drmsResourceSkills2);	
						System.out.println();
						System.out.println("333333333333333333333333333333333333333");
						System.out.println();
						System.out.println(drmsResourceSkills2.toString());
						System.out.println();
						System.out.println("333333333333333333333333333333333333333");
						System.out.println();
				}else {
					System.out.println(drmsResourceSkills2.toString());
						list2.add(drmsResourceSkills2);	
				}	
			}
			for (DrmsResourceSkills drmsResourceSkills : list2) {
				System.out.println();
				System.out.println();
				System.out.println(drmsResourceSkills);
				System.out.println();
				System.out.println();
			}
		
	 }

}
