package Testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Adminyoursloginpagetest 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
   @AfterTest
   public void closebrowser()
   {
	//driver.close();
   }
   @Test
   public void verifyloginfunctionlityWithValidDetails() throws InterruptedException
   {
	   By usernamel=By.xpath("//input[@id='Email']");
	   WebElement usernameL=driver.findElement(usernamel);
	   usernameL.clear();
	   Thread.sleep(3000);
	   usernameL.click();
	   Thread.sleep(3000);
	   usernameL.sendKeys("admin@yourstore.com");
	   Thread.sleep(3000);
	   By passwordl=By.xpath("//input[@id='Password']");
	   WebElement passwordL=driver.findElement(passwordl);
	   passwordL.clear();
	   Thread.sleep(3000);
	   passwordL.click();
	   Thread.sleep(3000);
	   passwordL.sendKeys("admin");
	   Thread.sleep(3000);
	   By clickonloginbutton=By.xpath("//button[text()='Log in']");
	   WebElement loginbuttonl=driver.findElement(clickonloginbutton);
	   loginbuttonl.click();
	   
   }
}
