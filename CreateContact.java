package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		
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

//		 * 6. Click on Create Contact
         driver.findElement(By.linkText("Create Contact")).click();
         
//		 * 7. Enter FirstName Field Using id Locator
         driver.findElement(By.id("firstNameField")).sendKeys("KeerthiMano");
 
//		 * 8. Enter LastName Field Using id Locator
         driver.findElement(By.id("lastNameField")).sendKeys("Manoharan");
         
//		 * 9. Enter FirstName(Local) Field Using id Locator
         driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Kt");
         
//		 * 10. Enter LastName(Local) Field Using id Locator
         driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Mano");
         
//		 * 11. Enter Department Field Using any Locator of Your Choice
         driver.findElement(By.name("departmentName")).sendKeys("Testing");

//		 * 12. Enter Description Field Using any Locator of your choice 
         driver.findElement(By.id("createContactForm_description")).sendKeys("Creating first new lead");
         
//		 * 13. Enter your email in the E-mail address Field using the locator of your choice
         driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ktkeerthi123@gmail.com");
         
//		 * 14. Select State/Province as NewYork Using Visible Text
         WebElement dropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
         Select state = new Select(dropDown);
         state.selectByVisibleText("New York");
         
//		 * 15. Click on Create Contact
         driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
         
//		 * 16. Click on edit button 
         driver.findElement(By.linkText("Edit")).click();

//		 * 17. Clear the Description Field using .clear
         driver.findElement(By.id("updateContactForm_description")).clear();
         
//		 * 18. Fill ImportantNote Field with Any text
         driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is the first new lead");
         
//		 * 19. Click on update button using Xpath locator
         driver.findElement(By.xpath("//input[@name='submitButton']")).click();
         
//		 * 20. Get the Title of Resulting Page.
         System.out.println(driver.getTitle()); 

	}

}
