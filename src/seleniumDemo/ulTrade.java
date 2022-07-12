package seleniumDemo;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ulTrade {
	public static void main(String[] args)
			throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\eclipse-workspace\\seleniumDemo\\Drivers\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Navigate to the site
		driver.get("https://qa-stage.ultradedev.net/");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div/div/div[5]/div[2]/div/button")).click();
		String firstwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			// Navigate to next window
			if (driver.getTitle().equals("MyAlgo Connect - Connect")) {
				System.out.println("Hello");
				driver.findElement(By.cssSelector("#root > div > div.login > div.title-container.text-center > div > div.mt-5 > a")).click();
				driver.close();
			}
			
	
	}
		driver.switchTo().window(firstwindow);
		Set<String> child = driver.getWindowHandles();
		Iterator<String> itr1 = child.iterator();
		while(itr1.hasNext()) {
			
			String window=itr1.next();
			driver.switchTo().window(window);
			if(driver.getTitle().equals("Algorand Wallet")) {
				System.out.println("Hello");
				driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/div/div/div[1]/div/label/input")).click();
				driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div/div/div/div[2]/button/div/div")).click();
			}
		}
		
	}
	}

		

