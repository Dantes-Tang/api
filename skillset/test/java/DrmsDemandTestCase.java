import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.service.DrmsDemandService;
import com.mysql.fabric.xmlrpc.base.Data;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsDemandTestCase {
	@Autowired
	private DrmsDemandService drmsDemandService;
/*	@Test
	public void insertDrmsDemand() {
		DrmsDemand drmsDemand = new DrmsDemand();
		drmsDemand.setDmdAssCapId(1);
		drmsDemand.setDmdAtpId(1);
		drmsDemand.setDmdOppId(1);
		drmsDemand.setDmdDsgId(1);
		drmsDemand.setDmdId(1);
		drmsDemand.setDmdAssCapId(1);
		drmsDemand.setDmdResId(1);
		drmsDemand.setDmdsiteId(1);
		drmsDemand.setDmdAlertdsg(new Date().toString());
		drmsDemand.setDmdResType("ceshi");
		drmsDemand.setDmdAllocRatio("ceshi");
		drmsDemand.setDmdProjName("DRMS");
		drmsDemand.setStartDate("2016-10-06");
		drmsDemand.setEndDate("2016-10-6");
		drmsDemand.setDmdPosition("JerryTest");
		
		drmsDemandService.insertDrmsDemand(drmsDemand);
	}	*/
}
