package test_signIn;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Config;
import pageHelper.SignInSignup;

public class VerifyUserFullName extends Config{

	SignInSignup signIn = new SignInSignup();
	
	@Test 
	public void userFullNameTest(){
		System.out.println ("This test is going to assert user full name ONLY");
		// click on sign in link from header
		clickByXpath (signIn.signInLinkLoc);

		// enter email Require two things, locator and value
		//driver.findElement(By.xpath("//*[@id='username'")).sendKeys("test@gmail.com"); // IQBAL BHAI
		//driver.findElement(By.xpath(signIn.emailLoc)).sendKeys(signIn.emailValue); // OR
		typeByCss (signIn.emailLoc, signIn.emailValue); // re-use the method/function
	
		// click Next button after entering the email
		clickByXpath (signIn.nextButtonLoc);
		
		typeByXpath (signIn.passwordLoc, signIn.passValue);
		// click Sign In button after enter the password
		clickByXpath (signIn.signInButtonLoc);
		// Assert --- most important 
		String act = driver.findElement(By.xpath(signIn.myActualFullNameLoc)).getText(); 
		//System.out.println("my actual name is " + act);
		String cleanString = act.replaceAll("\r", "").replaceAll("\n", "");
		String myActFullName = cleanString.substring(0, 20);
		
		System.out.println("my actual name is " + myActFullName);
		String exp = "TalentTEK Consulting"; // exp is coming from Requirement or Mock-up
		Assert.assertEquals(myActFullName, exp);

	}
}
