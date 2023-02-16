package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.PasswordPage;
import pages.StartBrowser;

public class PasswordTestSuite {

	static WebDriver driver = null;
	
	@BeforeTest
	public void startUp() throws IOException {
		StartBrowser openConnection = new StartBrowser(driver);
		driver = openConnection.initializeBrowser();
	}
	
	@Test
	public void changePasswordSuccessfully() throws IOException, InterruptedException {
		
		System.out.println("change password test starts");
		
		LoginTestSuite login = new LoginTestSuite(driver);
		login.successfulLogin();
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickProfileButton();
		Thread.sleep(2000);
		dashboard.clickSecurityButton();	
		
		PasswordPage password = new PasswordPage(driver);
		Thread.sleep(3000);
		password.verifyChangePasswordTextIsPresent();
		Thread.sleep(3000);
		password.inputOldPassword("Top_secret123");
		Thread.sleep(2000);
		password.inputNewPassword("Top_secret1234");
		Thread.sleep(2000);
		password.clickChangePasswordButton();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Close Browser Successfully");
	}
}
