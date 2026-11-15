package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-email' and @name='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
		
	}
	
	public void setPassword(String pwd) {
	    txtPassword.sendKeys(pwd);  // Correct!
	}
	
	public void clickLogin() {

	    By loginButton = By.xpath("//input[@value='Login']");

	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.elementToBeClickable(loginButton)
	    ).click();
	}
	}
	
	

