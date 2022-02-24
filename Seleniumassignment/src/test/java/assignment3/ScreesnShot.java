package assignment3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

public class ScreesnShot {
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
	public void takeShot()throws Exception{

		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("D:\\screenshot") + "/screenshot");
			FileUtils.copyFile(source, target);
		}
		catch(IOException e) {
			System.out.println("Message: "+e.getMessage());
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	

}
