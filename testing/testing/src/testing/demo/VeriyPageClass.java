package testing.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VeriyPageClass {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	  driver=new ChromeDriver();
   	  String URL="http://automationpractice.com/index.php";

   	  driver.get(URL);
   	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	  driver.manage().window().maximize();
	}
	@Test
	public void verifyPageTitle()
	{
		System.out.println("verify Page");
		String title = driver.getTitle();
		System.out.println("the page title is "+title);
		Assert.assertEquals(title, "My Store");
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
