package easybix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FindElements {
	
	WebDriver driver = null;
@Test	
 public void openfacebook() {
	System.setProperty("webdriver.ie.driver", "C://Drivers//IEDriverServer_Win32_3.8.0//IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	
	driver.get("https://www.facebook.com");
	WebElement firstname = driver.findElement(By.cssSelector("input[id='u_0_n']"));
	WebElement lastname = driver.findElement(By.name("lastname"));
	
	//WebElement doblink = driver.findElement(By.partialLinkText("Why do I need to"));
	 WebElement headerText = driver.findElement(By.className("_53jh"));
	
	 firstname.sendKeys("Anshul");
	lastname.sendKeys("Chauhan");
	System.out.println(headerText.getText());
	
	driver.close();
 }

}
