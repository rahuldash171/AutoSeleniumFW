package AutomationPractice.baseComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	
	public WebDriver initializeDriver() throws IOException
	
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//AutomationPractice//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		} else if (browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
				
		}else if (browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		driver = initializeDriver();
		driver.get("http://automationpractice.com/");
	}
	@AfterMethod
	public void teatDown()
	{
		driver.close();
	}
}
