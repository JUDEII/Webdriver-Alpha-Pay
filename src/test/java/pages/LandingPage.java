package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	private WebDriver driver = null;
	By signupButton = By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]");
	By getStartedButton = By.xpath("//body/div[@id='root']/div[1]");
	By loginButton = By.xpath("//button[contains(text(),'LOG IN')]");
	By landingImage = By.xpath("//header/nav[1]/div[1]/div[1]/img[1]");
	
	public static void main(String[] args) {
		
	}
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignupButton() {
		driver.findElement(signupButton).click();
		System.out.println("Sign up button clicked successfully");
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
		System.out.println("Sign up button clicked successfully");
	}
	
	public void verifyLogoIsPresent() {
		int size = driver.findElements(landingImage).size();
		assertEquals(size,1);
		System.out.println("landingImage is not present");
	}
	
	public void verifygetStartedButtonPresent() {
		int size = driver.findElements(getStartedButton).size();
		assertEquals(size,1);
		System.out.println("getStarted Button is not present");
	}
}
