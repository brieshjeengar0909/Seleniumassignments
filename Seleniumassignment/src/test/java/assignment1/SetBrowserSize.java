package assignment1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SetBrowserSize {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	
	}
	@Test
	public void browserSize() {
		Dimension before = driver.manage().window().getSize();  
		System.out.println("Browser window size before setting: "+before);
		 driver.manage().window().setSize(new Dimension(1200,900));   
		Dimension after = driver.manage().window().getSize();
		System.out.println("Browser window size after setting: "+after);
		
		
		// TODO Auto-generated method stub
		
	}
	@AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.close();
	  }


}
