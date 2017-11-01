import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsAllocationType;
import com.capgemini.drms.service.DrmsAllocationTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsAllocationTypeTest {
	@Autowired
	private DrmsAllocationTypeService drmsAllocationTypeService;

	@Test
	public void insertAllcationTyprTest() {
		DrmsAllocationType drmsAllocationType = new DrmsAllocationType();
		drmsAllocationType.setAtpId(2);
		drmsAllocationType.setAtpName("hz");
		drmsAllocationTypeService.insertDrmsAllocationType(drmsAllocationType);
	}

	@Test
	public void selectAllocationTypeTest() {
		List<DrmsAllocationType> drmsAllocationtypes = drmsAllocationTypeService
				.searchAllocationTypeAll();
		for (DrmsAllocationType drmsAllocationType : drmsAllocationtypes) {
			System.out.println(drmsAllocationType.getAtpId() + " "
					+ drmsAllocationType.getAtpName());
		}
	}

	@Test
	public void updateAllocationTypeTest() {
		DrmsAllocationType allocationType = new DrmsAllocationType();
		allocationType.setAtpId(2);
		allocationType.setAtpName("cq");
		drmsAllocationTypeService.updateDrmsAllocationType(allocationType);
	}
}
