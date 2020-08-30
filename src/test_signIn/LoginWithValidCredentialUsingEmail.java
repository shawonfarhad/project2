package test_signIn;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Config;
import pageHelper.SignInSignup;

public class LoginWithValidCredentialUsingEmail extends Config{

	SignInSignup signIn = new SignInSignup();
	
	@Test
	public void loginWithValidCredentialUsingEmailTest(){
		System.out.println ("login With Valid Credential Using Email Test start");
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
		// act is coming from Domain -- the one developer build and release
		// coding needed -- genius level 1
		String exp = "TalentTEK Consulting "; // exp is coming from Requirement or Mock-up
		Assert.assertEquals(act, exp);

	}
}
