package oppurtunity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditOppurtunity {

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
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("keerthiha",Keys.ENTER);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//table/tbody/tr/th[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")).click();
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='slds-dropdown__item']//span)[3]"));
		driver.executeScript("arguments[0].click()",ele );
		
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
        driver.findElement(By.xpath("(//span[@class='slds-day'])[34]")).click();
		
        Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@part='combobox']/label/abbr//following::button")).click();
	    driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
	    Thread.sleep(2000);
	    //driver.executeScript("window.scrollBy(0,700)");
	    driver.executeScript("document.querySelector('.actionBody').scrollBy(0,600)");
	    WebElement ele2 = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_')])[4]"));
	    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //wait.until(ExpectedConditions.elementToBeClickable(ele2));
	    ele2.click();
	    driver.findElement(By.xpath("//span[@title='In progress']")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div/textarea[@class='slds-textarea']")).sendKeys("SalesForce Automation practice");
	    
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    
	    String stage = driver.findElement(By.xpath("//a[@data-tab-name=\"Perception Analysis\"]/span[2]")).getText();
	    System.out.println(stage);
	    if(stage.equals("Perception Analysis")) {
	    	System.out.println("Successfully edited the oppurtunity");
	    }else {
	    	System.out.println("There is a error, try again");
	    }
	    driver.close();
	}
}
