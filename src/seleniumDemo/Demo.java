package seleniumDemo;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	private static String text;

	public static void main(String[] args)
			throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		int n = 1;
		int b=2;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\eclipse-workspace\\seleniumDemo\\Drivers\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Navigate to the site
		driver.get("https://wallet.myalgo.com/");

		driver.findElement(By.className("_1yxs8iu")).click(); // Clicking on the T&C check box
		driver.findElement(By.className("_1wy2dtkm")).click(); // Clicking on the continue button
		Thread.sleep(1000);
		// Enter Password
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("Anu@2022");
		Thread.sleep(1000);
		// Confirm Password
		driver.findElement(By.cssSelector("form>div>div:nth-child(5)>div:nth-child(2)>input")).sendKeys("Anu@2022");
		Thread.sleep(1000);
		// Clicking on Continue button
		driver.findElement(By.className("_1wy2dtkm")).click();
		Thread.sleep(1000);
		for (int k = 0; k <= n; k++) {
			// Clicking on new account tab
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// mnemonic Phrase Continue Button
			driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div/div[2]/button"))
					.click();
			// Copy the Phrase
			driver.findElement(By.cssSelector(
					"#root > div._p4w042 > div._ojuzno > div:nth-child(1) > div._27goqx > button:nth-child(2) > img"))
					.click();

			// Fetching data from ClipBoard
			String text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			System.out.println(text);
			// Converting ClipBoard String into array
			String text1[] = text.split(", ");

			// Click on Check box and Continue
			driver.findElement(By.className("_1pknp6j")).click();
			driver.findElement(By.className("_t2mr9i")).click();
			Thread.sleep(2000);

			// Copy all the index value displaying on the phrase compare page
			for (int i = 1; i <= 4; i++) {
				// getting index of mnemonic array
				String s = driver.findElement(By.cssSelector("._1frr4gj>div:nth-child(" + i + ")>div>div:nth-child(2)"))
						.getText();
				int code = Integer.parseInt(s);// converting string number into int
				// Store the word in t variable.
				String t = text1[code - 1];
				// Fetch all the words displaying on the phrase comparing page
				for (int j = 1; j <= 4; j++) {
					// checking text in first option
					String g = driver.findElement(By.cssSelector("._zmhbi1>div:nth-child(" + j + ")>button")).getText();

					// Comparing t with g
					if (t.equals(g)) {
						//System.out.println("reached");
						driver.findElement(By.cssSelector("._zmhbi1>div:nth-child(" + j + ")>button")).click();
						break;
					}
				}
			}
			// Enter the account name
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[1]/div[5]/div/input"))
					.sendKeys("New" + k + "");
			Thread.sleep(2000);
			// Click on the create account
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[1]/div[6]/button")).click();
			// Enter the password
			driver.findElement(
					By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/div[1]/div[2]/input"))
					.sendKeys("Anu@2022");
			Thread.sleep(2000);
			// Click on the create button
			driver.findElement(
					By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/button/div/div"))
					.click();
			Thread.sleep(3000);
			// Click on add new account
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/div[1]/div[1]/span[1]/span"))
					.click();
			Thread.sleep(3000);
		}
		
		
		
		
		
		
		// Navigate to qa-stage.ultradedev.net
		driver.navigate().to("https://qa-stage.ultradedev.net/");
		// Click on the connect button
		driver.findElement(By.className("connectWallet_head")).click();
		// Handle multiple windows
		String firstwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			// Navigate to next window
			if (driver.getTitle().equals("MyAlgo Connect - Allow")) {
				// Enter the password
				driver.findElement(By.xpath(
						"//*[@id=\"root\"]/div/div/div/div/div[1]/div[3]/div/div[2]/div/form/div[1]/div[1]/input"))
						.sendKeys("Anu@2022");
				Thread.sleep(2000);
				driver.findElement(By
						.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[3]/div/div[2]/div/form/div[2]/button[2]"))
						.click();
				Thread.sleep(2000);
				//Select all the created wallets
				for(int l=2;l<=b+1;l++) {
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/div["+ l +"]")).click();
				}
				Thread.sleep(2000);
				//Click on the continue button
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[3]/div/div/button[2]"))
						.click();
				
			

		}
			

	}
		//Switch to parrent tab 
		driver.switchTo().window(firstwindow);
		driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[1]")).click();
	}}
