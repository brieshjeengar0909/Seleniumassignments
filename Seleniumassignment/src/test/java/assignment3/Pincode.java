package assignment3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Pincode {
WebDriver driver;
	
  	
  	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://chennaiiq.com/chennai/pincode-by-name.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
  	@Test
	public void testPincode()throws Exception{
		
		WebElement tablePin = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
		
		List<WebElement> row =tablePin.findElements(By.tagName("tr"));
		for(int i=3;i<row.size();i++)
		{
			List<WebElement> col =row.get(i).findElements(By.tagName("td"));
			String pinA = col.get(2).getText();
			
			for(int j=i;j<row.size();j++)
			{
				List<WebElement> colNew =row.get(j).findElements(By.tagName("td"));
				String pinB = colNew.get(2).getText();
				Assert.assertFalse(pinA==pinB);
			}
			
	
		}
		   
	}
	
	@AfterMethod
	public void tearDown()throws Exception{
	
					driver.close();
		}
	

}
