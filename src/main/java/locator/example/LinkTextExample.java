package locator.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement register = driver.findElement(By.partialLinkText("REGI"));
		WebElement destination = driver.findElement(By.partialLinkText("your"));
		WebElement img = driver.findElement(By.tagName("img"));
		WebElement link = driver.findElement(By.tagName("a"));
		WebElement img1 = driver.findElement(By.tagName("img"));

		// destination.click();
		// register.click();
	}
}
