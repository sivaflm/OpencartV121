package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_AccountRegistrationTest extends BaseClass {
	public WebDriver  driver;
	
@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
		
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void verify_account_registration() 
	{
		
		logger.info("*****Starting TC001_Account RegistrationTest ****");
		try {
			
		
		HomePage hp = new HomePage(driver);
		
		hp.linkAccount();
		logger.info("*****Starting click my account****");
		
		hp.linkRegister();
		logger.info("providing customer details");
		
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		rp.setFirstName("sai");
		rp.setLastName("Kumar");
		rp.setEmail("abcff455@gmail.com");
		rp.setTelephone("9084737380");
		rp.setPassword("xyz123456");
		rp.setConfirmPassword("xyz123456");
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		String confmg = rp.getConfirmationMsg();
		Assert.assertEquals(confmg, "Your Account Has Been Created!");
		
		} 
		catch(Exception e)
		{
			logger.error("Test failed..");
			logger.debug("debug Logs..");
			Assert.fail();
		}
	}
	
}
