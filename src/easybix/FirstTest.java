package easybix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FirstTest {
	
	WebDriver driver = null;
	String browser ="ie";
	
	String edgePath = "C://Drivers//MicrosoftWebDriver.exe";
	String chromePath ="C://Drivers//ChromeDriver//chromedriver.exe";
	String mozillaPath = "C://Drivers//geckodriver.exe";
	String iePath = "C://Drivers//IEDriverServer_Win32_3.8.0//IEDriverServer.exe";
	
	public void invokeBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver", mozillaPath);
			driver= new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", iePath);
			driver = new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", edgePath);
			driver = new EdgeDriver();
		}
	}
	@Test
	public void invokeApplication() {
		invokeBrowser(browser);
		driver.get("http://www.easybix.com");
		driver.manage().window().maximize();
		driver.close();
	}
}
