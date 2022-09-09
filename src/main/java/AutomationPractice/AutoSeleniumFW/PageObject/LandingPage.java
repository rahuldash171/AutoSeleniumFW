package AutomationPractice.AutoSeleniumFW.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement SignInbttn;
	
	public void ButtonClick()
	{
		SignInbttn.click();
	}
	


}
