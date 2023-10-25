package week7.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		 ChromeDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get("http://leaftaps.com/opentaps/control/login");
		 driver.manage().window().maximize();

         //Enter UserName and Password Using Id Locator
 		 driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
 		 driver.findElement(By.id("password")).sendKeys("crmsfa");
 		
         //click on Login Button using Class Locator
 		 driver.findElement(By.className("decorativeSubmit")).click();
	 
         //click on CRM/SFA Link
 		 driver.findElement(By.linkText("CRM/SFA")).click();
 		 
 		 //click leads
 		 driver.findElement(By.linkText("Leads")).click();
 		 
 		 //click merge leads
 		 driver.findElement(By.linkText("Merge Leads")).click();
 		 
 		 //click on 'From lead' icon
		 driver.findElement(By.xpath("//span[text()='From Lead']/following::img[1]")).click();
		 
		 //to get the window handles
		 Set<String> childWindow = driver.getWindowHandles();
		 
		 List<String> child1 = new ArrayList<String>(childWindow);
		 
		 //to move the control to child window
		 driver.switchTo().window(child1.get(1));
		 
		 //click on the resulting first lead
		 driver.findElement(By.xpath("//div[contains(@class,'x-grid3-hd-inner')]/following::a[@class='linktext']")).click();
		 
		 //again move the control to parent window
		 driver.switchTo().window(child1.get(0));
		 
		 //click on 'To lead' icon 
		 driver.findElement(By.xpath("//span[@class='requiredField']/following::img[2]")).click();
		 
		 //to get the window handles
         Set<String> childWindow1 = driver.getWindowHandles();
		 
		 List<String> child2 = new ArrayList<String>(childWindow1);
		 
		 //to move the control to child wondow2
		 driver.switchTo().window(child2.get(1));
		 
		 //click on any of the resulting leads
		 driver.findElement(By.xpath("//div[contains(@class,'x-grid3-hd-inner')]/following::a[@class='linktext'][12]")).click();
		 
		 //to move the control to parent window again
		 driver.switchTo().window(child2.get(0));
		 
		 //click on the merge button
		 driver.findElement(By.linkText("Merge")).click();
		 
		 //handle alert
		 driver.switchTo().alert().accept();
	}
}
