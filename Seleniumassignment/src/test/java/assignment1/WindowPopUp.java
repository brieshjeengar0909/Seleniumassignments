package assignment1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowPopUp {
	WebDriver driver;
	 
	  @BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://demo.automationtesting.in/Windows.html");
		  driver.manage().window().maximize();
	  }

	  @Test
	  public void Window_Popup() throws InterruptedException {
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.linkText("click")).click();
		  
		 System.out.println( driver.getTitle());
		 
		Set <String> s = driver.getWindowHandles();
		
		for(String i:s) {
			System.out.println(i);
			String T = driver.switchTo().window(i).getTitle();
			System.out.println(T);
			
			if(T.contains("Selenium")) {
				driver.close();
			}
			
		}
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
