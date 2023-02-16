package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.StartBrowser;

public class LogoutTestSuite {

	static WebDriver driver = null;

	@BeforeTest
	public void startUp() throws IOException {
		StartBrowser openConnection = new StartBrowser(driver);
		driver = openConnection.initializeBrowser();
	}
	
	@Test
	public void logoutSuccessful() throws IOException, InterruptedException {
		
		System.out.println("logout test starts");
		
		LoginTestSuite login = new LoginTestSuite(driver);
		login.successfulLogin();
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickProfileButton();
		Thread.sleep(2000);
		dashboard.clickLogoutButton();
		Thread.sleep(2000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLogoIsPresent();
		Thread.sleep(3000);
		
		System.out.println("Logout test is successful");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Close Browser Successfully");
	}
}
