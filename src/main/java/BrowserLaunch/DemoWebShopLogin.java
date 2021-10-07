package BrowserLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShopLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demowebshop.tricentis.com/");
		WebElement login = driver.findElement(By.className("ico-login"));
		login.click();
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		// email.sendKeys("archanaprasannan2014@gmail.com");
		// password.sendKeys("test@123");
		// loginButton.click();
		String buttonText = loginButton.getAttribute("value");
		System.out.println(buttonText);
		String buttonTagName = loginButton.getTagName();
		System.out.println(buttonTagName);
		Point buttonLocation = loginButton.getLocation();
		System.out.println(buttonLocation.x);
		System.out.println(buttonLocation.y);
		String buttonColor = loginButton.getCssValue("color");
		System.out.println(buttonColor);
		System.out.println(loginButton.isDisplayed());
		System.out.println(loginButton.isEnabled());

		driver.close();

	}

}
