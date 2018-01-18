package easybix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class InvokeBrowser1 {

	public void InvokeChrome() {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com");
		
		driver.close();
	}
 
  public void InvokeIE() {
	  System.setProperty("webdriver.ie.driver", "C://Drivers//IEDriverServer_Win32_3.8.0//IEDriverServer.exe");
	  
	  WebDriver driver = new InternetExplorerDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.easybix.com");
	  driver.close();
  }
  @Test
  public void InvokeFirefox() {
	  System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver.exe");
	  
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://www.easybix.com");
	  driver.close();
}
  public void InvokeEdge() {
	  System.setProperty("webdriver.edge.driver", "C://Drivers//MicrosoftWebDriver.exe");
	  
	  WebDriver driver = new EdgeDriver();
	  driver.get("http://www.easybix.com");
	  driver.close();
}
}  
  
