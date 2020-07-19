package testing.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartClass {

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
	public void addToCartTest() throws InterruptedException {
		System.out.println("Add To Cart Page");
		Actions actions=new Actions(driver);
		WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
		WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
		actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
		Thread.sleep(2000);
		String ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
		System.out.println(ProductName);
		driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
		driver.findElement(By.name("submit_search")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
		
	}
	
	
	
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.close();
//	}
}
