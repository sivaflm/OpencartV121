package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//a[@title = 'My Account']") WebElement lnkMyAccount;
	@FindBy (xpath= "//a[normalize-space() = 'Register']") WebElement lnkRegister;
	
	
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]") WebElement linkLogin;

	public void linkAccount ()
	{
		lnkMyAccount.click();
	}
	
	public void linkRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	
	{
		linkLogin.click();
	}
}
