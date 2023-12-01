package oppurtunity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteOppurtunity {

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
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Keerthiha",Keys.ENTER);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//table/tbody/tr/th[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")).click();
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='slds-dropdown__item']//span)[2]"));
		driver.executeScript("arguments[0].click()",ele );
		
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
//		//div[@class='emptyContentInner slds-text-align_center']
		Thread.sleep(3000);
		String deletedOpp = driver.findElement(By.xpath("//div/p/lightning-formatted-rich-text/span")).getText();
		//div[@class='emptyContentInner slds-text-align_center']/p/lightning-formatted-rich-text/span
		System.out.println(deletedOpp);
		
		
		if(deletedOpp.contains("No items to display")) {
			System.out.println("Oppurtunity is deleted");
		}else {
			System.out.println("Oppurtunity is not deleted, try again");
		}
		driver.close();
	}
}
