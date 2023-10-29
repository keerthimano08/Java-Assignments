package org.week7_Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
//		Assignment 2:Nykaa
//		=============
//		1) Go to https://www.nykaa.com/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications","start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");
		
//		2) Mouseover on Brands and Search L'Oreal Paris
		Actions a = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		a.moveToElement(brands).build().perform();
		
//		3) Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']//li[@class='brand-logo menu-links'][5]")).click();
		
//		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println("Title: "+driver.getTitle());
		
//		5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();
		
//		6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
//		7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Colour Protection']")).click();
//		8)check whether the Filter is applied with Shampoo
		System.out.println("Applied filter : "+driver.findElement(By.xpath("//span[@class='filter-value']"))
		.getText());
		
		Thread.sleep(3000);
//		9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
		
//		10) GO to the new window and select size as 175ml
		Set<String> newWindow = driver.getWindowHandles();
		List<String> productWindow = new ArrayList<String>(newWindow);
		driver.switchTo().window(productWindow.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		
//		11) Print the MRP of the product
		System.out.println("MRP: "+driver.findElement(By.xpath("//span[text()='MRP:']/following::span")).getText());
		
//		12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
//		13) Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		
//		14) Print the Grand Total amount
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span")).getText();
		int grandTotal = convertToInt(price);
		System.out.println("Grand Total: "+grandTotal);
		
//		15) Click Proceed
        Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
//		16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
//		17) Check if this grand total is the same in step 14
		driver.findElement(By.xpath("//div[@data-testid='back_button']")).click();
		driver.findElement(By.xpath("(//span[@data-testid='end-icon'])[2]")).click();
		String price2= driver.findElement(By.xpath("(//div[@class='css-vlqrtx e1d9ugpt3'])[3]")).getText();
		int finalPrice = convertToInt(price2);
		System.out.println("Final price: "+finalPrice);
		
		if(grandTotal==finalPrice) {
			System.out.println("Price is validated");
		}else {
			System.out.println("Price is mismatching");
		}
//		18) Close all windows
		driver.quit();
	}
	
	public static int convertToInt(String a) {
		String replaceAll = a.replaceAll("\\D", "");
		int parseInt = Integer.parseInt(replaceAll);
		
		return parseInt ;
	}
}
