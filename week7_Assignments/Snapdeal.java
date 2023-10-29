package org.week7_Assignments;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	
	public static void main(String[] args) throws InterruptedException {
		
//		1. Launch https://www.snapdeal.com/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications","start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.snapdeal.com/");
		

//		2. Go to Mens Fashion
		driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]")).click();
//		3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
//		4. Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following::span"))
				.getText();
		
		System.out.println("Total count of sports shoes: " + convertToInt(count));
		
//		5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
//		6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();
		
//		7. Check if the items displayed are sorted correctly
		
//		8.Select the price range (900-1200)
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("400");
		
		WebElement toValue = driver.findElement(By.name("toVal"));
		toValue.clear();
		toValue.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
//		9.Filter with color Navy 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		
//		10 verify the all applied filters 
//		System.out.println(driver.findElement(By.xpath("//div[@class='navFiltersPill']")).getText());
		List<WebElement> appliedFilters = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
		for (int i = 0; i < appliedFilters.size(); i++) {
		System.out.println(appliedFilters.get(i).getText());
		}
//		11. Mouse Hover on first resulting Training shoes
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		a.moveToElement(ele).perform();
		
//		12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
//		13. Print the cost and the discount percentage
		System.out.println("Cost: "+driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println("Discount: "+driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		
//		14. Take the snapshot of the shoes.
		
//		15. Close the current window
        driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
        
//		16. Close the main window
		driver.close();
}
	
	public static int convertToInt(String a) {
		String replaceAll = a.replaceAll("\\D", "");
		int parseInt = Integer.parseInt(replaceAll);
		return parseInt ;
	}
	
}
