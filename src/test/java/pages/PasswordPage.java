package pages;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import methods.UniqueId;

public class PasswordPage {

	private WebDriver driver = null;

	By changePasswordText = By.xpath("//p[contains(text(),'Change Password')]");
	By oldPassword = By.name("password");
	By newPassword = By.name("new_password");
	By changePasswordBtn = By.xpath("//button[contains(text(),'Change Password')]");
	
	
	public PasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	UniqueId uniqueId = new UniqueId(driver);
	
    public void verifyChangePasswordTextIsPresent() {
		String text = driver.findElement(changePasswordText).getText();
		int size = driver.findElements(changePasswordText).size();
		assertEquals(size,1);
		assertEquals(text, "Change Password");
		System.out.println("changePasswordText is present");
    }
    
    public void inputOldPassword(String text) {
		driver.findElement(oldPassword).sendKeys(text);
    	String oldPw = driver.findElement(oldPassword).getText();
		System.out.println(oldPw);
		System.out.println("oldPassword Successfully Entered");
    }
    
    public void inputNewPassword(String text) {
    	String result = text + uniqueId.getUniqueString();
		driver.findElement(newPassword).sendKeys(result);
		System.out.println(result);
		System.out.println("newPassword Successfully Entered");
    }
    
	public void clickChangePasswordButton() {
		driver.findElement(changePasswordBtn).click();
		System.out.println("Change password button clicked successfully");
	}
}
