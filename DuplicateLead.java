package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) {
		
//		* 1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		
//		8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
//		9	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("keerthi123@gmail.com");
		
//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
//		11	Capture name of First Resulting lead
		String oldName = driver.findElement(By.xpath("//a[text()='kt']")).getText(); 
		System.out.println("Captured name is: " + oldName);
		
//		12	Click First Resulting lead
		driver.findElement(By.xpath("//a[text()='kt']")).click();
		
//		13	Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
//		14	Verify the title as 'Duplicate Lead'
		System.out.println(driver.getTitle());
		
//		15	Click Create Lead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
//		16	Confirm the duplicated lead name is same as captured name
		String newName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Duplicated name is: " + newName);
		
		/*
		 * if(oldName == newName) {
		 * System.out.println("captured name is same as duplicated name"); }else {
		 * System.out.println("captured name is not same as duplicated name"); }
		 */
		
//		17	Close the browser (Do not log out)
        driver.close();
	}

}
