package automationFramework;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order {

			static int c = 1;
			public static WebDriver driver;
			
				  public static void OrderCreate() throws InterruptedException 
				  
			{
			     System.setProperty("webdriver.chrome.driver","D:\\Automation\\Drivers\\chromedriver.exe");
			     driver = new ChromeDriver();
			     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			    Login the application
			     driver.get("http://templatebar.com/Individual/hiba/magento6/admin/");
			     driver.findElement(By.id("username")).sendKeys("admin");
			     driver.findElement(By.id("login")).sendKeys("hiba@2017");
			     driver.findElement(By.xpath("//span[text()='Sign in']/..")).click();
			     Thread.sleep(3000);
//			    Alert message close
			       driver.findElement(By.xpath("//span[text()='Close']/..")).click();
			       Thread.sleep(2000);
//			    Click on sales        
			       driver.findElement(By.xpath("//span[text()='Sales']/..")).click();        
			       Thread.sleep(1000); 
//			    Click on Orders link
			       driver.findElement(By.xpath("//span[text()='Orders']")).click();
//			    Create New Order        
			       driver.findElement(By.xpath("//span[text()='Create New Order']")).click();        
			       Thread.sleep(2000);
//			    Cell selection and click on Cell in Table        
			       driver.findElement(By.ByClassName.id("sales_order_create_customer_grid_table"));  
			       System.out.println(driver.getTitle());
			       WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));  // //tr[@title='13']
			       JavascriptExecutor js=(JavascriptExecutor)driver;
			       (js).executeScript("arguments[0].click();", cell);        
			       System.out.println("Data for Row 2 and Column 3 is "+cell.getText()+".");        
			       System.out.println(cell);
			       
			       System.out.println(js.executeScript("return order.setStoreId('1')"));        
			       Thread.sleep(9000);
			//   Add Products page        
			       WebElement element = driver.findElement(By.xpath("//span[text()='Add Products']"));        
			       Actions actions = new Actions(driver);        
			       actions.moveToElement(element).click().perform();
			       Thread.sleep(4000);        
			       driver.findElement(By.ByClassName.id("sales_order_create_search_grid_table"));
			      
			       driver.findElement(By.xpath("//input[@id='id_55']")).click(); //-- 1st Row of Product is selection from table.
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//input[@id='id_54']")).click(); // --2nd Row of Product is selection from tabl        
			       Thread.sleep(2000);
//			    Products are added to [Add selected Product(s) to Order]        
			        driver.findElement(By.xpath("//span[contains(text(),'Add Selected Product(s) to Order')]")).click();       
			        Thread.sleep(3000); 
//			    Billing Address 
			        driver.findElement(By.xpath("//input[@name='order[billing_address][firstname]']")).sendKeys("User");         
			        driver.findElement(By.id("order-billing_address_lastname")).sendKeys(""+c);
			        Thread.sleep(2000);
			        driver.findElement(By.id("order-billing_address_street0")).sendKeys("street"+c);
			        Thread.sleep(2000);
			        driver.findElement(By.id("order-billing_address_city")).sendKeys("Kolkata");
			        Thread.sleep(2000);
			        Select s= new Select (driver.findElement(By.id("order-billing_address_region_id")));        
			        s.selectByValue("12");        
			        driver.findElement(By.id("order-billing_address_postcode")).sendKeys("12345");       
			        Random obj= new Random();        
			        int rgen1= obj.nextInt(100000);       
			        String cellnum = ("079393" + rgen1);       
			        System.out.println(cellnum);
			        Thread.sleep(2000);
			        driver.findElement(By.id("order-billing_address_telephone")).sendKeys(cellnum);
			        Thread.sleep(3000);
//			    Scroll section        
			        WebElement scroll = driver.findElement(By.xpath("//input[@id='order-billing_address_postcode']"));
			        scroll.sendKeys(Keys.PAGE_DOWN);
			        Thread.sleep(4000);
			// Payment method selection
			      WebElement paymentmethod = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.id("p_method_cashondelivery"))); 

			        paymentmethod.click();
			        Thread.sleep(4000);
			        WebElement shippingRates = (new WebDriverWait(driver, 15))
			             .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@onclick='order.loadShippingRates();return false']"))); 
			        shippingRates.click();
			        Thread.sleep(4000);      
			        driver.findElement(By.id("s_method_flatrate_flatrate")).click();        
			        Thread.sleep(4000); 

			// Submit Order
			       driver.findElement(By.xpath(" //button[@title='Submit Order']")).click();  
			       
			       System.out.println("Order created successfully");

			       driver.quit();
	        
			}
	}


