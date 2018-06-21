package automationFramework;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Customer 
            {
			 public static void CustomerCreate() throws InterruptedException 
			 {
			  System.setProperty("webdriver.chrome.driver","D:\\Automation\\Drivers\\chromedriver.exe");

			  WebDriver driver = new ChromeDriver();

			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			  driver.get("http://templatebar.com/Individual/hiba/magento6/admin/");

			  driver.findElement(By.id("username")).sendKeys("admin");

			  driver.findElement(By.id("login")).sendKeys("hiba@2017");

			  driver.findElement(By.xpath("//span[text()='Sign in']/..")).click();

			  Thread.sleep(3000);

			  driver.findElement(By.xpath("//span[text()='Close']/..")).click();

			  Thread.sleep(2000);
			  
			  driver.findElement(By.xpath("//span[text()='Customers']/..")).click();
			  
			  Thread.sleep(1000);
			  
			  driver.findElement(By.xpath("//span[text()='All Customers']")).click();
			  
			  driver.findElement(By.xpath("//button[@id ='add']")).click();
			  
			  String uuid = UUID.randomUUID().toString();

			  driver.findElement(By.name("customer[firstname]")).sendKeys(uuid);
			  
			  driver.findElement(By.name("customer[lastname]")).sendKeys("Bushrah");
			  
			   Random rad = new Random();
			         for (int j=1; j<=1; j++ )
			         {
			          driver.findElement(By.name("customer[email]")).sendKeys("User"+rad.nextInt(100)+"@yopmail.com");  
			         }
			  
			  driver.findElement(By.name("customer[dob]")).sendKeys("08/22/1994");
			  
			  driver.findElement(By.name("customer[gender]")).sendKeys("Female");
			  
			  driver.findElement(By.xpath("//span[text()= 'Save Customer']")).click();
			 
			  System.out.println("Customer created successfully");
			  
			  driver.quit();
			 
			 }
	}


