package automationFramework;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
            
public class Product 
	{
	  public static void ProductCreate() throws InterruptedException 
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

driver.findElement(By.id("menu-magento-catalog-catalog")).click();

WebElement ele=driver.findElement(By.xpath("//span[text()='Catalog']/.."));

((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);

driver.findElement(By.xpath("//button[@data-ui-id='products-list-add-new-product-button-dropdown']")).click(); 

driver.findElement(By.xpath("//span[@title='Simple Product']")).click();

//driver.findElement(By.name("product[name]")).sendKeys(genData.generateRandomString(20));

String uuid = UUID.randomUUID().toString();

driver.findElement(By.name("product[name]")).sendKeys(uuid);

/*WebElement fName=driver.findElement(By.name("product[name]"));

fName.sendKeys("Motorola1");

System.out.println(fName.getText());*/

WebElement pprice=driver.findElement(By.name("product[price]"));

pprice.sendKeys("500");

System.out.println(pprice.getText());

WebElement qtyy=driver.findElement(By.name("product[quantity_and_stock_status][qty]"));

qtyy.sendKeys("500");

System.out.println(qtyy.getText());

WebElement wt=driver.findElement(By.name("product[weight]"));

wt.sendKeys("10");

System.out.println(wt.getText());

driver.findElement(By.xpath("//div[@class='admin__action-multiselect-text'][contains(text(),'Select...')]")).click();

driver.findElement(By.xpath("//li[@class='admin__action-multiselect-menu-inner-item _root _parent']/div[@class = 'action-menu-item _expended _with-checkbox']")).click();

driver.findElement(By.xpath("//li[@class='admin__action-multiselect-menu-inner-item']/div/label")).click();

driver.findElement(By.xpath("//button[@class='action-default']")).click();

Thread.sleep(2000);

driver.findElement(By.xpath(".//*[@name='product[visibility]']")).click();

Select opt = new Select(driver.findElement(By.xpath(".//*[@name='product[visibility]']")));

opt.selectByValue("4");

Thread.sleep(2000);

driver.findElement(By.cssSelector("button.ui-datepicker-trigger.v-middle")).click();

driver.findElement(By.linkText("26")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();

driver.findElement(By.linkText("30")).click();

Thread.sleep(2000);

new Select(driver.findElement(By.name("product[country_of_manufacture]"))).selectByVisibleText("United States");

Thread.sleep(2000);

driver.findElement(By.id("save-button")).click();

System.out.println("Product created successfully");

driver.quit();


		
}

}
	

