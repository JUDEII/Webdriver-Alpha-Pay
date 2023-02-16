package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver = null;
	
	By imageSrc = By.xpath("//body/div[@id='root']/section[1]/div[1]/div[1]/img[1]");
	By loginButton = By.xpath("//button[contains(text(),'LOG IN')]");
	By emailField = By.name("email");
	By passwordField = By.name("password");
	By signInButton = By.xpath("//button[contains(text(),'Sign In')]");
	By resetLink = By.linkText("Reset");
	By registerLink = By.linkText("Register");
	By welcomeText = By.xpath("//p[contains(text(),'Welcome back, Please log in to your account to acc')]");
	By FundButton = By.xpath("(//button[contains(text(),'Fund Wallet')])[2]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyLogoIsPresent() {
		if(driver.findElement(imageSrc).isDisplayed())
		{
			System.out.println("Logo is present");
		}else {
			System.out.println("logo is absent");
		}
	}
	
	public void verifyWelcomeTextIsPresent() {
		String message = driver.findElement(welcomeText).getText();
		if(driver.findElement(welcomeText).isDisplayed() && message.equals("Welcome back, Please log in to your account to access your dashboard"))
		{
			System.out.println("welcomeText is present");
		}else {
			System.out.println("welcomeText is absent");
		}
		assertEquals(message, "Welcome back, Please log in to your account to access your dashboard");
	}
	
	
	public void clearEmailField() {
		driver.findElement(emailField).clear();
		System.out.println("email Text Field Successfully Cleared");
	}
	
	public void clearPasswordField() {
		driver.findElement(passwordField).clear();
		System.out.println("password Field Successfully Cleared");
	}
	
	public void enterTextInEmailField(String text) {
		driver.findElement(emailField).sendKeys(text);
		System.out.println("Email Successfully Entered");
	}
	
	public void enterTextInPasswordField(String text) {
		driver.findElement(passwordField).sendKeys(text);
		System.out.println("Password Successfully Entered");
	}
	
	public void resetPasswordLinkIsPresent() {
		if(driver.findElement(resetLink).isDisplayed())
		{
			System.out.println("reset password link is present");
		}else {
			System.out.println("reset password link is absent");
		}
		assertEquals(resetLink, "reset password link is present");

	}
	
	public void registerLinkIsPresent() {
		if(driver.findElement(registerLink).isDisplayed())
		{
			System.out.println("register link is present");
		}else {
			System.out.println("register link is absent");
		}
		assertEquals(registerLink, "register link is present");
	}
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
		System.out.println("Sign in button clicked successfully");
	}
	
	public void clickReturnToHomepage() {
		driver.findElement(imageSrc).click();
		System.out.println("returnToHomepageButton clicked successfully");
	}
	
	public void FundButtonIsPresent() {
		String message = driver.findElement(FundButton).getText();
		if(driver.findElement(FundButton).isDisplayed())
		{
			System.out.println("FundButton is present");
		}else {
			System.out.println("FundButton is absent");
		}
		assertEquals(message, "Fund Wallet");
	}
	
}
