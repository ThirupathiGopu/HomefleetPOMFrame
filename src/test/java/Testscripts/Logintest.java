package Testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.homefleet.pages.Loginpage;
import com.homfleet.utilites.Browser;
import com.homfleet.utilites.Dataconfigurevalidation;
import com.homfleet.utilites.ExtentReportsManager;
import com.homfleet.utilites.PropertyReader;

public class Logintest 
{
	WebDriver driver;
	PropertyReader pro;
	Loginpage lo;
	@BeforeTest
	public void setup() throws Exception
	{
		pro=new PropertyReader("loginpage");
		driver=Browser.LanchBrowser(pro.Getdata("browser"));
		driver.get(pro.Getdata("url"));
	}
	@AfterTest
	public void Closebrowser()
	{
		driver.close();
		ExtentReportsManager.stopReport();
	}
	@Test
	public void Verify_LoginFunctionality_withValidData() throws Exception
	{
		ExtentReportsManager.startTest("Homefleetloginfunctionality", "Test case Description", "validateToData");
		ExtentReportsManager.startReport();
		lo=new Loginpage(driver);
		lo.Enterusername(pro.Getdata("username"));
		lo.Enterpassword(pro.Getdata("password"));
		lo.ClickonLoginbutton();
		Thread.sleep(2000);
		lo.successmsg();
		lo.Textmsg();
		ExtentReportsManager.logInfo("launch browser ");
		ExtentReportsManager.logInfo("Browser will open and enter to url details ");
		ExtentReportsManager.logInfo("Navigate to application login page ");
		ExtentReportsManager.logInfo("Enter to user name ");
		ExtentReportsManager.logInfo("Enter to password");
		ExtentReportsManager.logInfo("click to login button ");
		ExtentReportsManager.logInfo("Verified login success toast message");
		ExtentReportsManager.logPass("Login Successfull", Dataconfigurevalidation.validateTologinsuccessfullmsg);
		ExtentReportsManager.logInfo("Navigate to dashboard and property list page");
		ExtentReportsManager.logInfo("Verified to add property text and button display or not  ");
		
	}

}
