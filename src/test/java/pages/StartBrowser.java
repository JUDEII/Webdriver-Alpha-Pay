package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StartBrowser {
	
private WebDriver driver = null;
	
	public StartBrowser(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver initializeBrowser() throws IOException {
		Properties config = new Properties();
		FileInputStream fetchFile = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\config\\config.properties");
		config.load(fetchFile);
		String browserName = config.getProperty("browser");
		String chromeSettings = config.getProperty("setChromeToHeadless");
		String chromeBrowserResolution = config.getProperty("chromeBrowserResolution");

		boolean useheadless;
		if (chromeSettings.equals("true")) {
			useheadless = true;
			System.out.println("Tests will be run in *HEADLESS* mode");
		} else {
			useheadless = false;
			System.out.println("Tests will NOT be run in headless mode");
		}
	
		if (browserName.equals("chrome87")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver87.exe");
			ChromeOptions option = new ChromeOptions();
			option.setHeadless(useheadless);
			option.addArguments(chromeBrowserResolution);
			this.driver = new ChromeDriver(option);
		}
		else if (browserName.equals("chrome89")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver89.exe");
			ChromeOptions option = new ChromeOptions();
			option.setHeadless(useheadless);
			//option.addArguments(chromeBrowserResolution);
			option.addArguments("window-size=1280x800");
			this.driver = new ChromeDriver(option);
		}
		else if (browserName.equals("fireFox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");	
			this.driver = new FirefoxDriver();
			
			} else {
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriver\\IEDriverServer.exe");	
				driver = new FirefoxDriver();
			}
						
			System.out.println("Browser Initialize. Test Passed");
			return driver;
					
		}
	
	public void launchBaseUrl() throws IOException {
		Properties config = new Properties();
		FileInputStream fetchFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
		config.load(fetchFile);
		String url = config.getProperty("baseUrl");
		System.out.println(url);
		
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.get(url);
		this.driver.manage().window().maximize();
		//this.driver.manage().window().setSize(new Dimension(1024, 600));
		System.out.println("Browser Successfully Initiated");
	}
	

}
