package assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleAccount {
WebDriver driver;
	
  	
  	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
  	@Test
	public void GoogleAccount() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("joni");
		String firstname= driver.findElement(By.xpath("//*[@id=\"firstName\"]")).getAttribute("id");
		System.out.println("The attribute of first name is: " +firstname);
		Thread.sleep(1500);
		driver.findElement(By.id("lastName")).sendKeys("bhau");
		String lastname= driver.findElement(By.xpath("//*[@id=\"lastName\"]")).getAttribute("id");
		System.out.println("The attribute of first name is: " +lastname);
		Thread.sleep(1500);
		driver.findElement(By.id("username")).sendKeys("jonibhau0");
		String username= driver.findElement(By.id("username")).getAttribute("id");
		System.out.println("The attribute of username is: " +username);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("abcd@12345");
		String password = driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).getAttribute("type");
		System.out.println("The attribute of username is: "+password);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("abcd@12345");
		String Confirmpassword = driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).getAttribute("aria-label");
		System.out.println("The attribute of username is: "+Confirmpassword);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();
		
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}


}
