package oppurtunity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateOppurtunityWithoutMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications","start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		driver.findElement(By.id("password")).sendKeys("Testleaf@1234");
		
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@role='navigation']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//lightning-button")).click();
		
		driver.findElement(By.xpath("//span[@part='formatted-rich-text']/following::p[2]")).click();
		
		
		WebElement oppurtunitiesTab =  driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", oppurtunitiesTab);
		driver.findElement(By.xpath("//a[@title='New']")).click();
	 
	    driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
        driver.findElement(By.xpath("(//span[@class='slds-day'])[32]")).click();
        
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    
	    //verification
//	    String s = driver.findElement(By.xpath("(//label[@class='slds-form-element__label'])[3]")).getText();
//	    System.out.println(s);
	    String helpText = "Complete this field.";
	    
	    String stage = driver.findElement(By.xpath("(//label[@class='slds-form-element__label'])[3]/following-sibling::div[2]")).getText();
	    Assert.assertEquals(helpText, stage);
	   
	    String oppName = driver.findElement(By.xpath("(//label[@class='slds-form-element__label slds-no-flex'])[2]/following::div[2]")).getText();
	    Assert.assertEquals(helpText, oppName);
	    driver.close();
	}
}
