package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{


	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven")//getting data provider from different package
	public void Verify_loginDDT(String email,String pwd, String exp) {
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.linkAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		//lp.setPassword(p.getProperty("Siva_12345"));
		lp.setPassword((pwd));
		lp.clickLogin();
		
		

		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page title: " + driver.getTitle());
		
		//MyAccountpage
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		
		//*Data is valid  - login success - test pass - log out - 1st if condition
		                   //login failed - test fail 
		
		//Data is invalid - login success - test fail - log out - 2nd if condition
                            //login failed - test pass 
		
		
		
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(targetPage==true) {
				macc.ClickLogout();
				Assert.assertTrue(true);
			
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetPage==true) {
				macc.ClickLogout();
				Assert.assertTrue(false);
			
			}
			
			else {
				Assert.assertTrue(true);			}
		}
		
		}
		catch (Exception e) {
		    Assert.fail("Login test failed: " + e.getMessage(), e);
		}
		
		
	}
}
