package week4.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) {
		
//		* 1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
//		* 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
//		* 3	Enter the password
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
//		* 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		* 5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
//		* 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
//		* 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
//		* 8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("kt");
		
//		* 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
//		* 10 Click on first resulting lead
		driver.findElement(By.linkText("mano")).click();
		
//		* 11 Verify title of the page
		System.out.println(driver.getTitle()); 
		
//		* 12 Click Edit
		
//		* 13 Change the company name
		
//		* 14 Click Update
		
//		* 15 Confirm the changed name appears
		
//		* 16 Close the browser (Do not log out)

		
        
		
		
		
		
		
//		driver.findElement(By.linkText("Create Lead")).click();
//		
//		//enter company name
//		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Keerthiha");
//		
//		//enter first name
//		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Keerthiha");
//		
//		//enter last name
//		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Selenium");
//		
//		//click on the create lead button
//		driver.findElement(By.className("smallSubmit")).click();
//		
//		//to print the title of the page
//		String title = driver.getTitle();
//		System.out.println(title);
		
		//close the web page
		//driver.close();

	}

}
