import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsAllocationType;
import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsDesigation;
import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.service.DrmsDemandService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsDemandTest {

	@Autowired
	private DrmsDemandService drmsDemandService;

	@Test
	public void testUpdate() {
		DrmsResource drmsResource=new DrmsResource();
		DrmsOpp drmsOpp = new DrmsOpp();
		drmsOpp.setOppId(1);
		drmsResource.setResourceId(1);
		drmsResource.setResourceName("hahahahahahha");
		DrmsSite drmsSite=new DrmsSite();
		drmsSite.setSiteId(1);
		drmsResource.setResourceName("hhhhhhhhhhhhh");
		DrmsDesigation drmsDesigation=new DrmsDesigation();
		drmsDesigation.setDsgId(1);
		drmsDesigation.setDsgName("ssssss");
		DrmsAllocationType drmsAllocationType=new DrmsAllocationType();
		drmsAllocationType.setAtpId(1);
		drmsAllocationType.setAtpName("hhhhhh");
		DrmsCapability drmsCapability=new DrmsCapability();
		drmsCapability.setCapId(1);
		drmsCapability.setCapName("hahhahh ");
		DrmsCapability drmsAssCapability=new DrmsCapability();
		drmsAssCapability.setCapId(1);
		drmsAssCapability.setCapName("drmsAssCapability ");
		
	
		DrmsDemand drmsDemand = new DrmsDemand();
		drmsDemand.setDmdResType("ssssss");
		drmsDemand.setDmdId(249);
		drmsDemand.setDrmsResource(drmsResource);
		drmsDemand.setDrmsCapability(drmsCapability);
		drmsDemand.setDmdAllocRatio("sssss");
		drmsDemand.setDrmsAssCapability(drmsAssCapability);
		drmsDemand.setDrmsDesigation(drmsDesigation);
		drmsDemand.setDrmsAllocationType(drmsAllocationType);
		drmsDemand.setDrmsOpp(drmsOpp);
		drmsDemand.setDmdPosition("sssss");
		drmsDemand.setDmdProjName("ssss");
		drmsDemand.setDrmsSite(drmsSite);
		drmsDemand.setDmdShowId("89888");
		drmsDemand.setDmdAlterdsg("ssss");
		Date date=new Date();
		drmsDemand.setStartDate(date);
		drmsDemand.setEndDate(date);
		int i = drmsDemandService.updateDrmsDemand(drmsDemand);
		System.out.println(i);

	}
	
	@Test
	public void insertDrmsDemand() {
		DrmsResource drmsResource=new DrmsResource();
		DrmsOpp drmsOpp = new DrmsOpp();
		drmsOpp.setOppId(1);
		drmsResource.setResourceId(1);
		drmsResource.setResourceName("hahahahahahha");
		DrmsSite drmsSite=new DrmsSite();
		drmsSite.setSiteId(1);
		drmsResource.setResourceName("hhhhhhhhhhhhh");
		DrmsDesigation drmsDesigation=new DrmsDesigation();
		drmsDesigation.setDsgId(1);
		drmsDesigation.setDsgName("ssssss");
		DrmsAllocationType drmsAllocationType=new DrmsAllocationType();
		drmsAllocationType.setAtpId(1);
		drmsAllocationType.setAtpName("hhhhhh");
		DrmsCapability drmsCapability=new DrmsCapability();
		drmsCapability.setCapId(1);
		drmsCapability.setCapName("Digital & TDI");
		DrmsCapability drmsAssCapability=new DrmsCapability();
		drmsAssCapability.setCapId(1);
		drmsAssCapability.setCapName("drmsAssCapability ");
		DrmsDemand drmsDemand = new DrmsDemand();
		drmsDemand.setDmdResType("test222");
		
		drmsDemand.setDmdResType("20170220");
		drmsDemand.setDmdId(11);
		drmsDemand.setDrmsResource(drmsResource);
		drmsDemand.setDrmsCapability(drmsCapability);
		drmsDemand.setDmdAllocRatio("sssss");
		drmsDemand.setDrmsAssCapability(drmsAssCapability);
		drmsDemand.setDrmsDesigation(drmsDesigation);
		drmsDemand.setDrmsAllocationType(drmsAllocationType);
		drmsDemand.setDrmsOpp(drmsOpp);
		drmsDemand.setDmdPosition("sssss");
		drmsDemand.setDmdProjName("ssss");
		drmsDemand.setDrmsSite(drmsSite);
		drmsDemand.setDmdShowId("AIG201600002");
		drmsDemand.setDmdAlterdsg("ssss");
		Date date=new Date();
		drmsDemand.setStartDate(date);
		drmsDemand.setEndDate(date);
		drmsDemandService.insertDrmsDemand(drmsDemand);
	}

	/*@Test
	public void searchDemand() {
		DrmsOpp drmsOpp = new DrmsOpp();
		drmsOpp.setOppId(1);
		List<DrmsDemand> demands = drmsDemandService.searchDrmsDemandById(drmsOpp);
		for (DrmsDemand demand : demands) {
			System.out.println(demand.getDmdId() + " " + demand.getDrmsOpp().getOppName()+" "+demand.getDrmsDesigation().getDsgId()+" "+demand.getDrmsAllocationType().getAtpName());

		}
	}*/
	@Test
	public void searchDemandTBD() {
		List<DrmsDemand> demands = drmsDemandService.searchDrmsDemandTBD();
		
		for (DrmsDemand demand : demands) {
			System.out.println(demand.getDmdId() + " " + demand.getDrmsOpp().getOppName()+" "+demand.getDrmsDesigation().getDsgId()+" "+demand.getDrmsAllocationType().getAtpName());

		}
	}
	@Test
	public void matchedDemands(){
  		List<Map<String, Object>> skillMatrixs = drmsDemandService.matchedResource(8);
  			for (Map<String, Object> map : skillMatrixs) {
				System.out.println(map.get("skills").toString());
			}
  		
		}
  		
  				
  	
	
	@Test
	public void notMatchedResource(){
		List<List<SkillMatrix>> arrs = drmsDemandService.notMatchedResource(8);
		for(List<SkillMatrix> arr : arrs){
			System.out.println("........."+arr.get(0).getFullName());
		}
	}

	@Test
	public void updateResourceId(){
		List<DrmsDemand> lists = drmsDemandService.updateDemandResourceId("Recruitment");
		for(DrmsDemand list:lists){
			System.out.println("..............."+list.getDmdProjName());
		}
	}
	@Test
	public void updateMacthedResourceId(){
		 drmsDemandService.updateMacthedResourceId(632, 73,2);	
	}
	@Test
	public void searchAllDemands(){
		List<DrmsDemand> allDemands = drmsDemandService.searchAllDemands();
		for(DrmsDemand demand:allDemands){
			System.out.println(demand.getDmdProjName()+","+demand.getDmdResType());
		}
	} 
	@Test
	public void searchDrmsdemadn(){
	    DrmsDemand drmsDemand = drmsDemandService.searchDrmsDemand(1);
	    System.out.println(drmsDemand.getDmdProjName());
	    
	}
	@Test
	public void searchDrmsDemandsByStatus(){
	    int status = 1;
	    List<DrmsDemand> drmsDemands = drmsDemandService.searchDemandsByStatus(status);
	    int count =0;
	    for (DrmsDemand drmsDemand : drmsDemands)
        {
	    	System.out.println();
            System.out.println(drmsDemand.getDrmsDemandStatus().getDmdStatusName());
            System.out.println();
            count++;
        }
	    System.out.println(count);
	    
	
	}
}
