package com.homefleet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.homfleet.utilites.Dataconfigurevalidation;

public class Loginpage 
{
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//elements
	@FindBy(xpath="//input[@name='email']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[text()='LOGIN']")WebElement loginbtn;
	@FindBy(xpath="//span[text()='Login Successfull']")WebElement Loginsuccessmsg;
	@FindBy(xpath="//span[text()='Property']")WebElement isdisplaytext;

	//actions
	public void Enterusername(String usernam)
	{
		username.clear();
		username.sendKeys(usernam);
	}
	public void Enterpassword(String pasword)
	{
		password.clear();
		password.sendKeys(pasword);
		
	}
	public void ClickonLoginbutton()
	{
		
		loginbtn.click();	
	}
	public void successmsg()
	{
		if(Loginsuccessmsg.isDisplayed())
		{
		String toastmsg=Loginsuccessmsg.getText();
		System.out.println(toastmsg);
		Assert.assertEquals(toastmsg, Dataconfigurevalidation.validateTologinsuccessfullmsg,"test case pass");
		}
		else
		{
			System.out.println("not display to login success toast msg");
		}
	}
	public void Textmsg()
	{
		String data=isdisplaytext.getText();
		System.out.println(data);
		Assert.assertEquals(data, Dataconfigurevalidation.validateTotextmsg,"test case pass");
		
	}
	
	
}
