import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsAccount;
import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.model.DrmsStatus;
import com.capgemini.drms.service.DrmsDemandService;
import com.capgemini.drms.service.DrmsOppService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsOppTest {
	@Autowired
	private DrmsOppService drmsOppService;
	@Test
	public void testInsertDrmsOpp() {
		 
		 
		 
		 DrmsOpp drmsOpp=new DrmsOpp();
		 DrmsStatus drmsStatus=new DrmsStatus();
		 drmsStatus.setStatusId(1);
		 drmsStatus.setStatusName("WIP");
		 DrmsAccount drmsAccount=new DrmsAccount();
		 drmsAccount.setAccountId(1);
		 drmsAccount.setAccountName("AIG");
		 drmsOpp.setOppId(111);
		 drmsOpp.setOppName("autoInsert");
		 drmsOpp.setOppProbability("90%");
		 drmsOpp.setDrmsStatus(drmsStatus);
		 drmsOpp.setDrmsAccount(drmsAccount);
		 drmsOppService.insertDrmsOpp(drmsOpp); 
	}
	@Test
	public void testUpdateOpp(){
	    
	    DrmsOpp drmsOpp=new DrmsOpp();
	    drmsOpp.setOppId(307);
	    DrmsStatus drmsStatus = new DrmsStatus();
	    drmsStatus.setStatusId(3);
	    drmsStatus.setStatusName("Closed");
	    drmsOpp.setDrmsStatus(drmsStatus);
	   
	   drmsOppService.updateDrmsOpp(drmsOpp);
	}
}
