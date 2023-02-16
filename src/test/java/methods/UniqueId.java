package methods;

import org.openqa.selenium.WebDriver;

public class UniqueId {

	private WebDriver driver = null;
	
	public UniqueId(WebDriver driver) {	
		this.driver  = driver;
	}
	
    public String getUniqueString(){
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(new java.util.Date().getTime()));
        return stringBuilder.reverse().substring(0, 6);    
    }
}
