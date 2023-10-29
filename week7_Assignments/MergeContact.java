package org.week7_Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {	
		
//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 ChromeDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get("http://leaftaps.com/opentaps/control/login");
		 driver.manage().window().maximize();
		 
//		 * 2. Enter UserName and Password Using Id Locator
		 driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
 		 driver.findElement(By.id("password")).sendKeys("crmsfa");
 		 
//		 * 3. Click on Login Button using Class Locator
 		 driver.findElement(By.className("decorativeSubmit")).click();
 		 
//		 * 4. Click on CRM/SFA Link
 		 driver.findElement(By.linkText("CRM/SFA")).click();
 		 
//		 * 5. Click on contacts Button
 		 driver.findElement(By.linkText("Contacts")).click();
 		 
//		 * 6. Click on Merge Contacts using Xpath Locator
 		 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//		 * 7. Click on Widget of From Contact
 		 driver.findElement(By.xpath("//span[text()='From Contact']/following::a")).click();
 		 
//		 * 8. Click on First Resulting Contact
 		 //to handle the child window
 		 Set<String> fromContactWindow = driver.getWindowHandles();
 		 List<String> openedWindow = new ArrayList<String>(fromContactWindow);
 		 driver.switchTo().window(openedWindow.get(1));
 		 
 		 driver.findElement(By.xpath("//div[contains(@class,'grid3-col-firstName')]/following::a")).click();
 		 driver.switchTo().window(openedWindow.get(0));
//		 * 9. Click on Widget of To Contact
 		 driver.findElement(By.xpath("//span[text()='To Contact']/following::a")).click();
 		 
//		 * 10. Click on Second Resulting Contact
 		 Set<String> toContactWindow = driver.getWindowHandles();
		 List<String> openedWindow2 = new ArrayList<String>(toContactWindow);
		 driver.switchTo().window(openedWindow2.get(1));
		 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[contains(@class,'grid3-col-firstName')]/following::a[7]")).click();
		 driver.switchTo().window(openedWindow2.get(0));
//		 * 11. Click on Merge button using Xpath Locator
         driver.findElement(By.xpath("//a[text()='Merge']")).click();
//		 * 12. Accept the Alert
         driver.switchTo().alert().accept();
//		 * 13. Verify the title of the page
         System.out.println(driver.getTitle());
         //driver.close();

	}

}
