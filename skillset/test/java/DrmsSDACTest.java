import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsSDAC;
import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.service.DrmsSDACService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsSDACTest {
	@Autowired
	private DrmsSDACService DrmsSDACService;
	@Test
	public void searchDrmsSDAC(){
		DrmsSDAC  drmsSDAC = DrmsSDACService.searchDrmsSDAC();
		for (int i = 0; i < drmsSDAC.getDrmsSite().size(); i++) {
			System.out.println(drmsSDAC.getDrmsSite().get(i).getSiteName()+"aaaaaaaaa");
		}
		for (int i = 0; i < drmsSDAC.getDrmsDesigation().size(); i++) {
			System.out.println(drmsSDAC.getDrmsDesigation().get(i).getDsgName()+"bbbbbbbbb");
		}
		for (int i = 0; i < drmsSDAC.getDrmsAllocationType().size(); i++) {
			System.out.println(drmsSDAC.getDrmsAllocationType().get(i).getAtpName()+"ccccccccc");
			
		}
		for (int i = 0; i < drmsSDAC.getDrmsCapability().size(); i++) {
			System.out.println(drmsSDAC.getDrmsCapability().get(i).getCapName()+"ddddddddddddd");
			
		}
	}
}
