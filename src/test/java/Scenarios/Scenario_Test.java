package Scenarios;


import org.testng.annotations.Test;

import GenricLibrary.BaseSteps;
import pomRepository.LoginPage;


public class Scenario_Test extends BaseSteps {

	@Test(priority = 1,groups = "smoke")

	public void logininTotheapplicaton() throws InterruptedException {
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String firstname = prop.getProperty("firstname");
		String lastname = prop.getProperty("lastname");
		String postalcode = prop.getProperty("postalcode");

		
		LoginPage login = new LoginPage(driver);
		login.login(username,password);
		
		
	
			
		}

	}
	

