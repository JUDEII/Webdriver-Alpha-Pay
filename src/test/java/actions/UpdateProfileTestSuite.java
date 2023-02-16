package actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LandingPage;
import pages.StartBrowser;
import pages.UpdateProfilePage;

public class UpdateProfileTestSuite {
	static WebDriver driver = null;
	
	@BeforeTest
	public void startUp() throws IOException {
		StartBrowser openConnection = new StartBrowser(driver);
		driver = openConnection.initializeBrowser();
	}
	
	@Test
	public void updateProfileSuccessfully() throws IOException, InterruptedException {
		
		System.out.println("update profile test starts");
		
		LoginTestSuite login = new LoginTestSuite(driver);
		login.successfulLogin();
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickProfileButton();
		
		UpdateProfilePage updateProfile = new UpdateProfilePage(driver);
		updateProfile.verifyProfilePictureIsPresent();

		//scroll to bottom of page
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		System.out.println("scroll to button is successsful");
		
		
		WebElement clearFullName = driver.findElement(By.cssSelector("input[name='full_name']"));
		WebElement clearUsername = driver.findElement(By.cssSelector("input[name='username']"));

		String clearText = Keys.chord(Keys.CONTROL, "a");
		Thread.sleep(2000);
		clearFullName.sendKeys(clearText);
		clearFullName.sendKeys(Keys.DELETE);
		System.out.println("Full name cleared");
		Thread.sleep(2000);
		
		clearUsername.sendKeys(clearText);
		clearUsername.sendKeys(Keys.DELETE);
		System.out.println("username cleared");
		Thread.sleep(2000);
		
//		updateProfile.clearFullNameField();	
//		Thread.sleep(2000);
//		updateProfile.clearUsernameField();
//		Thread.sleep(2000);
		updateProfile.enterTextInFullnameField("Jude Test");
		Thread.sleep(2000);
		updateProfile.enterTextInUsernameField("userTest13026");
		Thread.sleep(5000);
		
		updateProfile.verifyPhoneNumberFieldIsPresent();
		Thread.sleep(3000);
		updateProfile.verifyEmailFieldIsPresent();
		Thread.sleep(3000);
		updateProfile.clickUpdateDetailsButton();
		
		System.out.println("Update profile is successful");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Close Browser Successfully");
	}
}
