package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	private WebDriver driver = null;
	
	By logoImage = By.xpath("//body/div[@id='root']/section[1]/div[1]/div[1]/div[1]/img[1]");
	By overviewButton = By.xpath("//span[contains(text(),'Overview')]");
	By paymentsButton = By.xpath("//body/div[@id='root']/section[1]/div[1]/div[1]/div[2]/a[2]/span[1]");
	By cardsButton = By.xpath("//span[contains(text(),'Cards')]");
	By messagesButton = By.xpath("//span[contains(text(),'Messages')]");
	By sendMoneyButton = By.xpath("//a[contains(text(),'Send Money')]");
	By requestMoneyButton = By.xpath("//a[contains(text(),'Request Money')]");
	By billsButton = By.xpath("//a[contains(text(),'Airtime/Bills')]");
	By profileAccountButton = By.xpath("//body/div[@id='root']/section[1]/div[1]/div[1]/div[3]/a[1]/img[1]");
	By profileButton = By.xpath("//body/div[@id='root']/section[1]/div[1]/div[1]/div[3]/a[1]/img[1]");
	By securityButton = By.xpath("//a[contains(text(),'Security')]");
	By logoutButton = By.xpath("//a[contains(text(),'Log Out')]");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProfileButton() {
		driver.findElement(profileButton).click();
		System.out.println("profileButton");
	}
	
	public void clickSecurityButton() {
		driver.findElement(securityButton).click();
		System.out.println("securityButton");
	}
	
	public void clickLogoutButton() {
		driver.findElement(logoutButton).click();
		System.out.println("logoutButton");
	}
}
