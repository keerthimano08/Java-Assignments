package org.week7_Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundWindow {

	public static void main(String[] args) {
		
//		   login to leafground window tab
		
		   ChromeDriver driver = new ChromeDriver();
	       
	       driver.get("https://leafground.com/window.xhtml");
	       
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       
	       driver.manage().window().maximize();
	       
//	       to Click and Confirm new Window Opens 
	       
	       driver.findElement(By.xpath("//h5[contains(text(),'Confirm new Window')]/following::span")).click();
	       
	       Set<String> openedWindow = driver.getWindowHandles();
           List<String> newWindow = new ArrayList<String>(openedWindow);
           
           driver.switchTo().window(newWindow.get(1));
           
           System.out.println("New Window Title : " +driver.getTitle());
           driver.close();
           
           driver.switchTo().window(newWindow.get(0));
           
//         to Find the number of opened tabs
           
           driver.findElement(By.xpath("//h5[contains(text(),'opened tabs')]/following::span")).click();
	       
	       Set<String> openedTabs = driver.getWindowHandles();
           List<String> countTabs = new ArrayList<String>(openedTabs);
           
           System.out.println("Number of opened tabs:" +countTabs.size());
           driver.switchTo().window(countTabs.get(1)).close();
           driver.switchTo().window(countTabs.get(2)).close();
           driver.switchTo().window(countTabs.get(0));
           
//         to Close all windows except Primary
           
           driver.findElement(By.xpath("//h5[contains(text(),'except Primary')]/following::span")).click();
	       
	       Set<String> closeWindowExceptPrimary = driver.getWindowHandles();
           List<String> closeWindow = new ArrayList<String>(closeWindowExceptPrimary);
           
           System.out.println("Number of windows to be closed :" +(closeWindow.size()-1));
           
           int i=1;
           while(i<closeWindow.size()) {
           driver.switchTo().window(closeWindow.get(i)).close();
           i++;
           }
           driver.switchTo().window(closeWindow.get(0));
           
//         to Wait for 2 new tabs to open
          
           driver.findElement(By.xpath("//h5[contains(text(),'Wait for 2')]/following::span")).click();
           
           Set<String> windowDelay = driver.getWindowHandles();
           List<String> waitWindow = new ArrayList<String>(windowDelay);
           System.out.println("Wait Window 1 : " +driver.switchTo().window(waitWindow.get(1)).getTitle());
           System.out.println("Wait Window 2 : " +driver.switchTo().window(waitWindow.get(2)).getTitle());
           
           driver.quit();
	}

}
