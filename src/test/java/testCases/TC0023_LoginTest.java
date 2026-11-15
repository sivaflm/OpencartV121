package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

//email: sivaganeshkasani22@gmail.com
//password : Siva_12345
public class TC0023_LoginTest extends BaseClass  {

@Test(groups = {"sanity","master"})
public void verify_login()
{
	logger.info("starting ");
	try {
		
	
	//HomePage
	HomePage hp = new HomePage(driver);
	hp.linkAccount();
	hp.clickLogin();
	
	//LoginPage
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	//lp.setEmail("sivaganeshkasani22@gmail.com");
	//lp.setPassword(p.getProperty("Siva_12345"));
	//lp.setPassword(("Siva_12345"));
	lp.clickLogin();
	
	

	System.out.println("Current URL: " + driver.getCurrentUrl());
	System.out.println("Page title: " + driver.getTitle());
	
	//MyAccountpage
	
	MyAccountPage macc = new MyAccountPage(driver);
	boolean targetPage = macc.isMyAccountPageExists();
	
	Assert.assertTrue(targetPage);
}
	catch(Exception e) {
	    e.printStackTrace();
	    Assert.fail("Login test failed: " + e.getMessage());
	}
	
	
	
}
	
	
}
