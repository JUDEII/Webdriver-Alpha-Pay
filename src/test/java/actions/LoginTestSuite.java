package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;
import pages.StartBrowser;


public class LoginTestSuite {
	
	static WebDriver driver = null;
	public LoginTestSuite () {}
	public LoginTestSuite(WebDriver driver) {
		this.driver = driver;
	}
	
	@BeforeTest
	public void startUp() throws IOException {
		StartBrowser openConnection = new StartBrowser(driver);
		driver = openConnection.initializeBrowser();
	}
	
	@Test
	public void successfulLogin() throws IOException, InterruptedException {
		System.out.println("successfulLogin Test Starts");
		
		StartBrowser system = new StartBrowser(driver);
		system.launchBaseUrl();
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLoginButton();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLogoIsPresent();
		Thread.sleep(3000);
		loginPage.verifyWelcomeTextIsPresent();
		Thread.sleep(3000);
		loginPage.clearEmailField();
		loginPage.clearPasswordField();
		loginPage.enterTextInEmailField("judetestacct13026@email.com");
		loginPage.enterTextInPasswordField("Top_secret1234");
		Thread.sleep(3000);
		loginPage.clickSignInButton();
		Thread.sleep(5000);

		loginPage.FundButtonIsPresent();
		Thread.sleep(5000);
		
		System.out.println("Login Successful. Test Passed");	

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Close Browser Successfully");
	}
}
