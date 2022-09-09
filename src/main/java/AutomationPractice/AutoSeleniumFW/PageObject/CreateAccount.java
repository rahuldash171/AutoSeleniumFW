package AutomationPractice.AutoSeleniumFW.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class CreateAccount extends AbstractComponent {
	
	
	WebDriver driver;
	public CreateAccount(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="SubmitCreate")
	WebElement CreateAccount;
	
	@FindBy(id="email_create")
	WebElement emailTab;
	
	@FindBy(id="create_account_error")
	WebElement errorMessage;
	
	public void BlankCaseCheck()
	{
		CreateAccount.click();
		if(errorMessage.isDisplayed())
		{
			System.out.print("Blank TC");
		}
	}
	public void InvalidCaseCheck()
	{
		emailTab.sendKeys("Rahul");
		CreateAccount.click();
		if(errorMessage.isDisplayed())
		{
			System.out.print("Invalid TC");
		}
		
		
	}
	public void ValidCaseCheck()
	{
		emailTab.clear();
		emailTab.sendKeys("Rahul@yahoo.com");
		CreateAccount.click();
	}

}
