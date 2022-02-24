package assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderr {
	WebDriver driver;
	
  	
  	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
  	@DataProvider(name="Loginntestdata")
  	public Object[][] logindata() {
  		Object[][]data=new Object[2][2]; 
  		data[0][0]="Admin";
  		data[0][1]="admin123";
  		
  		data[1][0]="Admin";
  		data[1][1]="test123";
  		return data;
  	}
	
  	@Test(dataProvider="Loginntestdata")
  	public void f1(String userName,String password) throws InterruptedException {
  		driver.findElement(By.id("txtUsername")).sendKeys("userName");
  		driver.findElement(By.id("txtPassword")).sendKeys("password");
  		driver.findElement(By.id("btnLogin")).click();
  		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
  		Thread.sleep(5000);
  	}
  	@AfterMethod
  	public void afterMethod()
  	{
  		driver.close();
  	}
}
