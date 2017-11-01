
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.Country;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SearchModel;
import com.capgemini.drms.service.FlexibilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class FlexibilityTestCase {

	@Autowired
	private FlexibilityService flexibilityService;

	@Test
	public void searchChraUser() {
		SearchModel searchModel = new SearchModel();
//		searchModel.setCountry("guangzhou");
//		searchModel.setFullName("jay");
//		searchModel.setSkill("html");
		List<CapgUser> capgUsers = flexibilityService
				.searchCapgUser(searchModel);
		for (CapgUser user : capgUsers) {
			System.out.println("username:" + user.getUsername()
					+ "   fullName:" + user.getFullName());
		}

	}

	@Test
	public void getCountrys() {

		List<Country> countrys = flexibilityService.getCountrys();
		System.out
				.println("----------------------------------------------------"
						+ countrys.size());

	}

	@Test
	public void updateFlexibility() {
		Flexibility flexibility = new Flexibility();

		flexibility.setUsername("calvye");
		flexibility.setFullName("Calvin Ye");
		flexibility.setCountry("china");
		flexibility.setDuration("12");
		flexibilityService.updateFlexibility(flexibility);
	}

	@Test
	public void loadFlexibilityByUsername() {
		flexibilityService.loadFlexibilityByUsername("calvye");
	}

	@Test
	public void insertFlexibility() {
		Flexibility flexibility = new Flexibility();
		flexibility.setCountry("china");
		flexibility.setUsername("calvye");
		flexibility.setFullName("Calvin Ye");
		flexibility.setDuration("5");
		flexibilityService.insertFlexibility(flexibility);
	}

	@Test
	public void deleteFlexibility() {
		flexibilityService.deleteFlexibility("calvye");
	}

	@Test
	public void getLdapUser() {
		CapgUser capgUser = new CapgUser();
		capgUser.setUserName("calvye");

		capgUser = flexibilityService.loadCapgUser(capgUser);
		System.out.println("------------------" + capgUser.getFullName());
	}
}
