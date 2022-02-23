package assignment1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLink {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void BrokenLink() throws InterruptedException, IOException {
		 List <WebElement> links =  driver.findElements(By.tagName("a"));
		 System.out.print("Total links"+links.size());
		 for(int i=0;i<links.size();i++) {
			 WebElement element= links.get(i);
			 String Url = element.getAttribute("href");
				
				URL link = new URL(Url);
				
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				Thread.sleep(2000);
				httpconn.connect();
				
				int resp = httpconn.getResponseCode();
				
				if (resp >= 400)
				{
					System.out.println(Url + " - "+ " is broken link");
				}
				else {
					System.out.println(Url + " - "+ " is valid link");}
		 }
				
				}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		
	}

}
