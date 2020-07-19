package testing.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginClass {

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
	public void signInTest() {
		 
		   System.out.println("sign in page");
		   driver.findElement(By.linkText("Sign in")).click();
		   driver.findElement(By.id("email")).sendKeys("test1249@test.com");
		   driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
		   driver.findElement(By.id("SubmitLogin")).click();
		   System.out.println("Login successful...");
		   System.out.println("sign out page");
		   driver.findElement(By.linkText("Sign out")).click();
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   System.out.println("Logged out successfully");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
