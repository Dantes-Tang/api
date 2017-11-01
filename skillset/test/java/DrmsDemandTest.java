import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsAllocationType;
import com.capgemini.drms.model.DrmsCapability;
import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsDesigation;
import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.service.DrmsDemandService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsDemandTest {

	@Autowired
	private DrmsDemandService drmsDemandService;

	@Test
	public void testUpdate() {
		DrmsResource drmsResource=new DrmsResource();
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
	
		DrmsDemand drmsDemand = new DrmsDemand();
		drmsDemand.setDmdResType("ssssss");
		drmsDemand.setDmdId(11);
		drmsDemand.setDrmsResource(drmsResource);
		drmsDemand.setDrmsCapability(drmsCapability);
		drmsDemand.setDmdAllocRatio("sssss");
		drmsDemand.setDmdAssCapId(1);
		drmsDemand.setDrmsDesigation(drmsDesigation);
		drmsDemand.setDrmsAllocationType(drmsAllocationType);
		drmsDemand.setDmdOppId(1);
		drmsDemand.setDmdPosition("sssss");
		drmsDemand.setDmdProjName("ssss");
		drmsDemand.setDrmsSite(drmsSite);
		drmsDemand.setDmdShowId("111");
		drmsDemand.setDmdAlterdsg("ssss");
		int i = drmsDemandService.updateDrmsDemand(drmsDemand);
		System.out.println(i);

	}
	
	@Test
	public void insertDrmsDemand() {
		DrmsResource drmsResource=new DrmsResource();
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
	
		DrmsDemand drmsDemand = new DrmsDemand();
		drmsDemand.setDmdResType("test222");
		
		drmsDemand.setDmdResType("ssssss");
		drmsDemand.setDmdId(11);
		drmsDemand.setDrmsResource(drmsResource);
		drmsDemand.setDrmsCapability(drmsCapability);
		drmsDemand.setDmdAllocRatio("sssss");
		drmsDemand.setDmdAssCapId(1);
		drmsDemand.setDrmsDesigation(drmsDesigation);
		drmsDemand.setDrmsAllocationType(drmsAllocationType);
		drmsDemand.setDmdOppId(1);
		drmsDemand.setDmdPosition("sssss");
		drmsDemand.setDmdProjName("ssss");
		drmsDemand.setDrmsSite(drmsSite);
		drmsDemand.setDmdShowId("111");
		drmsDemand.setDmdAlterdsg("ssss");
		
		drmsDemand.setStartDate("2016-09-30");
		drmsDemand.setEndDate("2016-09-30");
		drmsDemandService.insertDrmsDemand(drmsDemand);
	}

	@Test
	public void searchDemand() {
		List<DrmsDemand> demands = drmsDemandService.searchDrmsDemandById(1);
		for (DrmsDemand demand : demands) {
			System.out.println(demand.getDmdId() + " " + demand.getDmdOppId()+" "+demand.getDrmsDesigation().getDsgId()+" "+demand.getDrmsAllocationType().getAtpName());

		}
	}
}
