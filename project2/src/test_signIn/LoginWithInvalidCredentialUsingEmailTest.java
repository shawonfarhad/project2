package test_signIn;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Config;
import pageHelper.SignInSignup;

public class LoginWithInvalidCredentialUsingEmailTest extends Config{
	
	SignInSignup signIn = new SignInSignup();
	
	@Test 
	public void loginwithInvalidPasswordTest(){
		System.out.println ("login With Valid Credential Using Email Test start");
		// click on sign in link from header
		clickByXpath (signIn.signInLinkLoc);

		// enter email Require two things, locator and value
		typeByCss (signIn.emailLoc, signIn.emailValue); // re-use the method/function
	
		// click Next button after entering the email
		clickByXpath (signIn.nextButtonLoc);
		
		typeByXpath (signIn.passwordLoc, signIn.invalidPassValue);
		// click Sign In button after enter the password
		clickByXpath (signIn.signInButtonLoc);
		
		// Assert --- most important 
		String act = driver.findElement(By.xpath(signIn.exectedEmailPassErrorMsg)).getText(); 
		// act is coming from Domain -- the one developer build and release
		String exp = "The email and password combination you entered doesn't match."; // exp is coming from Requirement or Mock-up
		Assert.assertEquals(act, exp);

	}

}
