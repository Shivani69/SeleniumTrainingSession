package easybix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
// if the actual and expected results don't match the testng execution will stop after assertEquals.
public class VerifyYahooTitle {
	String expectedTitle ="Yahoo";
@Test
	public void VerifyTitle(){
		
		System.setProperty("webdriver.chrome.driver","C://Drivers//ChromeDriver//chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.yahoo.com/");
		
		String ActualTitle = driver.getTitle();
		//Assert.assertTrue(condition);// if the condition passed is true it will return assert true or else false
		
		Assert.assertEquals(ActualTitle, expectedTitle);
		driver.close();
	}

}
