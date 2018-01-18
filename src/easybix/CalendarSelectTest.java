package easybix;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {
     System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		String date="31-September-2017";
		String dateArr[]= date.split("-");
		String day = dateArr[0];
		String month =dateArr[1];
		String year = dateArr[2];
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		
		String beforeXpath ="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath ="]/td[";
		final int totalWeekDays =7;
		
		boolean flag = false;
		String dayVal= null;
		for(int rowNum=2; rowNum<=7; rowNum++) {
			
			for(int colNum =1; colNum<=totalWeekDays; colNum++) {
		try {	
			 dayVal=driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
			}catch(NoSuchElementException e) {
				System.out.println("Please enter a correct date value");
				flag =  false;
				break;
			}
				System.out.println(dayVal);
				if(dayVal.equals(day)) {
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
	}

}
