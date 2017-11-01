import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsDemandStatus;
import com.capgemini.drms.model.DrmsStatus;
import com.capgemini.drms.service.DrmsDemandStatusService;
import com.capgemini.drms.service.DrmsStatusService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsStatusTest {
	@Autowired
	private DrmsDemandStatusService demandStatusService;
	@Test
	public void searchAllDemandStatus(){
		List<DrmsDemandStatus> status = demandStatusService.searchDemandStatuses();
		for(DrmsDemandStatus s:status){
			System.out.println(s.getDmdStatusName());
		}
	}

}
