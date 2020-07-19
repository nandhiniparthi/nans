package testing.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegristrationClass {

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
	public void RegristrationFormTest()
	{
		 System.out.println("registration page ");
		 driver.findElement(By.linkText("Sign in")).click();
		 driver.findElement(By.id("email_create")).sendKeys("a90@test.com");
		 driver.findElement(By.id("SubmitCreate")).click();
		 driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
		 driver.findElement(By.name("customer_firstname")).sendKeys("fname");
		 driver.findElement(By.name("customer_lastname")).sendKeys("lname");
		 driver.findElement(By.id("passwd")).sendKeys("password");
		 driver.findElement(By.id("firstname")).sendKeys("fname");
		 driver.findElement(By.id("lastname")).sendKeys("lname");
		 driver.findElement(By.id("address1")).sendKeys("Test address");
		 driver.findElement(By.id("city")).sendKeys("Test street");
		 driver.findElement(By.id("id_state")).sendKeys("California");
		 driver.findElement(By.name("postcode")).sendKeys("51838");
		 driver.findElement(By.id("id_country")).sendKeys("United States");
	   	 driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
	   	 driver.findElement(By.id("alias")).sendKeys("Office");
	   	 driver.findElement(By.name("submitAccount")).click();
	   	 String Text=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
	
	   
	   	 if(Text.contains("lname")) {
	   	  System.out.println("User Verified,Test case Passed");
	   	 }
	   	 else {
	   	  System.out.println("User Verification Failed,Test case Failed");
	   	 }
  		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
