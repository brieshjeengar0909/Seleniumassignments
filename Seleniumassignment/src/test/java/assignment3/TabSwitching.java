package assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabSwitching {
WebDriver driver;
String url = "http://demo.automationtesting.in/Windows.html";
	
  	
  	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void testTabSwitch()throws Exception{
			
			String urlNew = null;
			
			//click button
			driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
			
			for(String newTab:driver.getWindowHandles()) {
				
				driver.switchTo().window(newTab);
				urlNew = driver.getCurrentUrl();
				System.out.println(driver.getTitle());
			}
			
			//click on About option and showing sub-options
			WebElement webElement = driver.findElement(By.id("navbarDropdown"));
			Thread.sleep(4000);
			
			//for clicking sub-menus and click on Events option 
			webElement.click();
			Thread.sleep(4000);
            
			//loading Events tab
			driver.findElement(By.linkText("Events")).click();
			Thread.sleep(4000);	
			
			urlNew = driver.getTitle();
			Assert.assertTrue(!url.equals(urlNew)); //Assertion used for validation
			System.out.println(urlNew);
	}

	
	@AfterTest
	public void tearDown()throws Exception{

		    driver.quit();
	}


}
