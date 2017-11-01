package skillset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.CapgUserRole;
import com.capgemini.drms.service.AppUserService;
import com.capgemini.drms.service.FlexibilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class CapgUserTest {
	@Autowired
	private FlexibilityService flexibilityService;

	@Autowired
	private AppUserService appUserService;

	@Test
	public void capgUser() {
		List<CapgUser> capgUsers = flexibilityService.loadCapgUserByName();
		for (CapgUser capgUser : capgUsers) {
			System.out.println(capgUser.getEmail() + " "
					+ capgUser.getEmployeeId() + " " + capgUser.getPhone());
		}
	}

	@Test
	public void getFullName() {
		String email = appUserService.findFullName("senhu");
		System.out.println(email);
	}
	
}
