package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
		
//		8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
//		9	Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8855662233");
		
//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
//		11	Capture lead ID of First Resulting lead
		String leadId = driver.findElement(By.linkText("11293")).getText();
		System.out.println(leadId);
		
//		12	Click First Resulting lead
		driver.findElement(By.linkText("11293")).click();
		
//		13	Click Delete
		driver.findElement(By.linkText("Delete")).click();
		
//		14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
//		15	Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		
//		16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		System.out.println(driver.findElement(By.xpath("//div[text()='No records to display']")).getText());
		
//		18	Close the browser (Do not log out)
        driver.close();
	}
}
