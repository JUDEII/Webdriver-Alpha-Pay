package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class UpdateProfilePage {

	private WebDriver driver = null;
	
	By nameField = By.cssSelector("input[name='full_name']");
	By usernameField = By.cssSelector("input[name='username']");
	By phoneNumberField = By.cssSelector("input[name='phone_number']");
	By emailField = By.cssSelector("input[name='email']");
	By updateDetailsButton = By.xpath("//button[contains(text(),'Update Details')]");
	By profilePicture = By.xpath("//body/div[@id='root']/section[1]/div[1]/section[1]/main[1]/div[1]/section[1]/div[1]/label[1]/img[1]");
	
	public UpdateProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clearFullNameField() {
		driver.findElement(nameField).clear();
		System.out.println("full name field cleared successfully");
	}
	//userTest13026
	public void verifyProfilePictureIsPresent() {
		int size = driver.findElements(profilePicture).size();
		assertEquals(size,1);
		System.out.println("profile picture Element is present");
	}
	
	public void clearUsernameField() {
		driver.findElement(usernameField).clear();
		System.out.println("username field cleared successfully");
	}
	
	public void enterTextInFullnameField(String text) {
		driver.findElement(nameField).sendKeys(text);
		System.out.println("full name Successfully Entered");
	}
	
	public void enterTextInUsernameField(String text) {
		driver.findElement(usernameField).sendKeys(text);
		System.out.println("UserName Successfully Entered");
	}
	
	public void verifyPhoneNumberFieldIsPresent() throws InterruptedException {
		String message = driver.findElement(phoneNumberField).getAttribute("value");
		Thread.sleep(3000);
		int size = driver.findElements(phoneNumberField).size();
		if(driver.findElement(phoneNumberField).isDisplayed())
		{
			Assert.assertEquals(size,1);
			assertEquals(message, "0206645513026");
			System.out.println("phone number is present");
			System.out.println("field is not empty");
		}else {
			System.out.println("phone number is absent");
		}
	}
	
	public void verifyEmailFieldIsPresent() throws InterruptedException {
		String message = driver.findElement(emailField).getAttribute("value");
		Thread.sleep(3000);
		int size = driver.findElements(emailField).size();
		if(driver.findElement(emailField).isDisplayed())
		{
			Assert.assertEquals(size,1);
			assertEquals(message, "judetestacct13026@email.com");
			System.out.println("email is present");
			System.out.println("field is not empty");
		}else {
			System.out.println("phone number is absent");
		}
	}
	
	public void clickUpdateDetailsButton() {
		driver.findElement(updateDetailsButton).click();
		System.out.println("updateDetailsButton is successfully clicked");
	}

	
}
