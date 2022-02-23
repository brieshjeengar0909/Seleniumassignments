package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScriptithoutSendkeys {
	WebDriver driver;
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void f() throws InterruptedException {
		 WebElement username = driver.findElement(By.name("email"));
		 WebElement pw = driver.findElement(By.name("password"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  js.executeScript("arguments[0].value= 'agent@phptravels.com'", username);
		  js.executeScript("arguments[0].value= 'demoagent'", pw);
		  
		  Thread.sleep(2000);

		  driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button/span[1]")).click();
		
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
		
	}

}
