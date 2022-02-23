package assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dragandDrop {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void dragndrop() throws InterruptedException {
		  WebElement Frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		  driver.switchTo().frame(Frame);
		WebElement From = driver.findElement(By.id("draggable"));
		  WebElement To = driver.findElement(By.id("droppable"));
		  Actions drag = new Actions(driver);
		  drag.dragAndDrop(From, To).build().perform();
		  Thread.sleep(2000);
		  String msg = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		  System.out.println(msg);
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
		
		
	}

}
