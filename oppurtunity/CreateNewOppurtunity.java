package oppurtunity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewOppurtunity {

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
	    
		String name = "Salesforce Automation by Keerthiha";
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
	
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@part='combobox']/label/abbr//following::button")).click();
	    
	    driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
        driver.findElement(By.xpath("(//span[@class='slds-day'])[33]")).click();
        
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    
	    Thread.sleep(3000);
	    String title = driver.getTitle();
	    if(title.contains(name)) {
	    	System.out.println("Title is verified");
	    }else {
	    	System.out.println("verfication failed");
	    }
	    driver.close();
	}
}
