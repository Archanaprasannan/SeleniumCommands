package locator.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathFindElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/newtours/");
		// WebElement username = driver.findElement(By.name("userName"));
		// username.sendKeys("archa2123@gmail.com");
		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

		WebElement submit = driver.findElement(By.xpath("//input[contains(@value,'Subm')]"));
		username.sendKeys("archa@gmail.com");
		password.sendKeys("test");
		submit.click();
		// driver.close();
	}

}
