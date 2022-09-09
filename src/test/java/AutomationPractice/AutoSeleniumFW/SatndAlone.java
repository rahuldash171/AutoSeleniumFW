package AutomationPractice.AutoSeleniumFW;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AutomationPractice.AutoSeleniumFW.PageObject.CreateAccount;
import AutomationPractice.AutoSeleniumFW.PageObject.LandingPage;
import AutomationPractice.baseComponent.BaseTest;

public class SatndAlone extends BaseTest{
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Rahul Dash");
	}

	@Test
	public void execution() throws IOException
	{
		// TODO Auto-generated method stub
		extent.createTest("Initial Test");
		CreateAccount createacc = new CreateAccount(driver);
		LandingPage landingpage = new LandingPage(driver);		
		landingpage.ButtonClick();
		createacc.BlankCaseCheck();
		createacc.InvalidCaseCheck();
		createacc.ValidCaseCheck();
	
		
	}
	
	@AfterTest
	public void endTest() 
	{
		extent.flush();
	}

}
