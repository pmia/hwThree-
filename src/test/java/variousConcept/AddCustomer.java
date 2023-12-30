//Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
//Enter username:  demo@techfios.com 
//Enter password: abc123
//Click login button
//Click on Customers button in the Side Navigation
//Click on Add Customer
//Fill in the Add Customer Form
//Click submit
//Go to CRM -> List Customer Page
//Search for the new Customer in the search field
//Validate contact Customer ​

package variousConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomer {
	WebDriver driver;

	@BeforeMethod
	public void Setup() {

		// ChromeDriver
		 System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		 driver = new ChromeDriver();

		// EdgeDriver
		//System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
		//driver = new EdgeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void AddCustomer() throws InterruptedException {

		// using Xpath Axes for login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		// using Xpath Axes to add customer
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a/span[1]")).click();
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Parves Mia");
		driver.findElement(By.xpath("//select[@id='cid']")).sendKeys("Apple");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7189625515");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1234demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("abc123");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("91-09 122nd place");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Hollis");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("NY");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("11423");
		driver.findElement(By.xpath("//button[@id='submit']")).click();

	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
