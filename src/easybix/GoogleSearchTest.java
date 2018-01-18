package easybix;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		
	List<WebElement>list =driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
	
	System.out.println("total number of suggestion in search box:::=====>"+list.size());
	
	for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().contains("java arraylist")) {
			list.get(i).click();
			break;
		}
	}

	}

}
