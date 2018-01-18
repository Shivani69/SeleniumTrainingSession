package easybix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		
		//create the instance of a Chrome Driver
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");// mentioning the https protocol is mandatory in case of selenium.
		
	}
	
		 
	
}
