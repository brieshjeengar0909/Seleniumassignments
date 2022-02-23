package assignment1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scroll {
	WebDriver driver;
	@BeforeTest
	public void BeforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	@Test
	public void ScrollPage() {
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		
	}
	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		driver.close();
	}

}
