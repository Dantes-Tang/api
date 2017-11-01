import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.WeeklyReport;
import com.capgemini.drms.service.WeeklyReportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class WeeklyReportTest {

	@Autowired 
	WeeklyReportService weeklyReportService;
	@Test
	public void testGetWeeklyReport() {
		List<WeeklyReport> list=weeklyReportService.getWeeklyReport();
		for (WeeklyReport weeklyReport : list) {
			System.out.print(weeklyReport.getCapability());
			System.out.print("-- ");
			System.out.print(weeklyReport.getBenchJoinDate());
			System.out.print("-- ");
			System.out.print(weeklyReport.getDesignation());
			System.out.print("-- ");
			System.out.print(weeklyReport.getDmdAllocRatio());
			System.out.print("-- ");
			System.out.print(weeklyReport.getDmdRemarks());
			System.out.print("-- ");
			System.out.print(weeklyReport.getGlobalJoinDate());
			System.out.print("-- ");
			System.out.print(weeklyReport.getKinId());
			System.out.print("-- ");
			System.out.print(weeklyReport.getName());
			System.out.print("-- ");
			System.out.print(weeklyReport.getPrimarySkill());
			System.out.print("-- ");
			System.out.print(weeklyReport.getAging());
			System.out.println();
			
		}
	}

}
