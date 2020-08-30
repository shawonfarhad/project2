package test_register;

import org.testng.annotations.Test;
import base.Config;

public class Gropping extends Config{

	// smoke test  ---> Prod -- or lower env (very very high level use cases)
	// regression ----> This suite needs to run in all lower env
	
	@Test (groups = { "Smoke" })
	public void loginWithEmail() {
		System.out.println("Smoke - TEST CASE 1");
	}

	@Test (groups = { "Regression" })
	public void loginWithFacebook() {
		System.out.println("Regression - test case 1");
	}

	@Test (groups = { "Smoke" })
	public void verifyHomePage() {
		System.out.println("Batch Smoke - Tes");
	}

	@Test (groups = { "Regression" })
	public void signUp() {
		System.out.println("Batch Regression test 2");
	}

	@Test (groups = { "Regression", "Smoke" })
	public void loginTest() {
		System.out.println("Run both Regression and Smoke suite");
	}

	
}





