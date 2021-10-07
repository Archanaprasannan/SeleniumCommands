package BrowserLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.get("http://demowebshop.tricentis.com/");
		driver.navigate().to("http://demowebshop.tricentis.com/");
		WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
		register.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@id,'LastNa')]"));
		firstName.sendKeys("test");
		lastName.sendKeys("refsh");
		driver.navigate().refresh();

		// driver.close();
	}
}
