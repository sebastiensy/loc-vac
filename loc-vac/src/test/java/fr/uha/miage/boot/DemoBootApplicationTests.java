package fr.uha.miage.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.uha.miage.locvac.LocVacApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LocVacApplication.class)
@WebAppConfiguration
public class DemoBootApplicationTests {

	@Test
	public void contextLoads() {
	}

}
