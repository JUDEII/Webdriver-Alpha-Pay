package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;
import pages.SignupPage;
import pages.StartBrowser;

public class SignUpTestSuite {

	static WebDriver driver = null;
	
	@BeforeTest
	public void startUp() throws IOException {
		StartBrowser openConnection = new StartBrowser(driver);
		driver = openConnection.initializeBrowser();
	}
	
	@Test
	public void signUpSuccessfully() throws IOException, InterruptedException {
		
		System.out.println("sign up test starts");
		
		//launch browser
		StartBrowser system = new StartBrowser(driver);
		system.launchBaseUrl();
		
		//click on signup button
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickSignupButton();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLogoIsPresent();
		Thread.sleep(3000);
		
		//fill sign up form
		SignupPage signup = new SignupPage(driver);
		signup.verifyCreateAccountMessageIsPresent();
		Thread.sleep(2000);
		signup.enterTextInNameField("jude test");
		Thread.sleep(2000);
		signup.enterTextUsernameField("judeUser");
		Thread.sleep(2000);
		signup.enterTextInPhoneNumberField("02066455");
		Thread.sleep(2000);
		signup.enterTextInEmailField("judetestacct");
		Thread.sleep(2000);
		signup.enterTextInPasswordField("Top_secret123");
		Thread.sleep(2000);
		signup.enterTextInConfirmPasswordField("Top_secret123");
		Thread.sleep(2000);
		signup.alreadyHaveAccountLinkIsPresent();
		Thread.sleep(2000);
		signup.clickCreateAccountButton();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Close Browser Successfully");
	}
}
