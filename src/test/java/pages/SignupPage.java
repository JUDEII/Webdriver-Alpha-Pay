package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import methods.UniqueId;

public class SignupPage {

	private WebDriver driver = null;

	By createAccountMessage = By.xpath("//p[contains(text(),'Create an alphapay account and join the community ')]");
	By fullNameField = By.name("full_name");
	By usernameField = By.name("username");
	By phoneNumberField = By.name("phone_number");
	By emailField = By.name("email");
	By passwordField = By.name("password");
	By confirmPasswordField = By.name("confirmPassword");
	By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
	By alreadyHaveAccountLink = By.linkText("Click here to sign in");
	
	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//create unique id
	UniqueId uniqueId = new UniqueId(driver);
	String id = uniqueId.getUniqueString();
	
    public void verifyCreateAccountMessageIsPresent() {
		String text = driver.findElement(createAccountMessage).getText();
		int size = driver.findElements(createAccountMessage).size();
		assertEquals(size,1);
		assertEquals(text, "Create an alphapay account and join the community of alphas");
		System.out.println("createAccountMessage is present");
    }
    
	public void enterTextInNameField(String text) {
		driver.findElement(fullNameField).sendKeys(text);
		System.out.println("Name Successfully Entered");
	}
	
	public void enterTextUsernameField(String text) {
		String result = text + id;
		driver.findElement(usernameField).sendKeys(result);
		System.out.println(result);
		System.out.println("Username Successfully Entered");
	}
	
	public void enterTextInPhoneNumberField(String text) {
		String result = text + id;
		driver.findElement(phoneNumberField).sendKeys(result);
		System.out.println(result);
		System.out.println("Phone number Successfully Entered");
	}
	
	public void enterTextInEmailField(String text) {
		String result = text + id + "@email.com";
		driver.findElement(emailField).sendKeys(result);
		System.out.println(result);
		System.out.println("Email Successfully Entered");
	}
	
	public void enterTextInPasswordField(String text) {
		driver.findElement(passwordField).sendKeys(text);
		System.out.println("Password Successfully Entered");
	}
	
	public void enterTextInConfirmPasswordField(String text) {
		driver.findElement(confirmPasswordField).sendKeys(text);
		System.out.println("Confirm password Successfully Entered");
	}
	
	public void clickCreateAccountButton() {
		driver.findElement(createAccountButton).click();
		System.out.println("createAccountButton is successfully clicked");
	}
	
	public void alreadyHaveAccountLinkIsPresent() throws InterruptedException {
		String message = driver.findElement(alreadyHaveAccountLink).getText();
		Thread.sleep(3000);
		int size = driver.findElements(alreadyHaveAccountLink).size();
		if(driver.findElement(alreadyHaveAccountLink).isDisplayed())
		{
			assertEquals(size,1);
			assertEquals(message, "Click here to sign in");
			System.out.println("link is present");
		}else {
			System.out.println("link is absent");
		}
		
	}
}
