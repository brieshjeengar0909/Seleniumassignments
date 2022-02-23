package assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Googlesearch {
	WebDriver driver;
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	  public void Google_Search() throws InterruptedException {
		  driver.findElement(By.name("q")).sendKeys("java"); //search keywords related to "automation tools"
			List<WebElement> webElement = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
			for(int i=0;i<webElement.size();i++)
			{
				String value = webElement.get(i).getText();
				if(value.contains("java jdk"))  //chooses "automation tools for testing"
				{
					Thread.sleep(5000);
					webElement.get(i).click();
					break;
				}
			}
	  }
	  

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }


}
