package org.week7_Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
	public static void main(String[] args) throws InterruptedException {
		
//		1.Load the URL https://www.amazon.in/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications","start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		
//		2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("onrplus 9 pro",Keys.ENTER);
		
//		3.Get the price of the first product
		String firstProductPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(firstProductPrice);
		
//		4. Print the number of customer ratings for the first displayed product
		String customerRatings = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"))
				.getText();
		System.out.println("Number of customer rating"+customerRatings);
		
//		5. Click the first text link of the first image
		driver.findElement(By.xpath("//h2[contains(@class,'a-color-base s-line-clamp-2')]")).click();
		
//		6. Take a screen shot of the product displayed
		
//		7. Click 'Add to Cart' button
		Set<String> newWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(newWindow);
		
	    driver.switchTo().window(childWindow.get(1));
		driver.findElement(By.id("add-to-cart-button")).click();
		
//		8. Get the cart subtotal and verify if it is correct.
		Thread.sleep(3000);
		String cartTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(cartTotal);
		
//		if(firstProductPrice==finalPrice) {
//			System.out.println("Price is validated");
//		}else {
//			System.out.println("Price is mismatching");
//		}
		
//		9.close the browser
		driver.quit();
	}
	
}
