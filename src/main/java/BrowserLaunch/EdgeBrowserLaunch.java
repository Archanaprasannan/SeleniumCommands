package BrowserLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserLaunch {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"D:\\SeleniumFiles\\DriverFiles\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/newtours/");

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println(title);
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		WebElement username = driver.findElement(By.name("userName"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		username.sendKeys("Test");
		password.sendKeys("password");
		submit.click();
		driver.close();

	}
}
