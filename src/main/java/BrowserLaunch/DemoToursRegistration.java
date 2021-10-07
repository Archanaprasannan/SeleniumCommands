package BrowserLaunch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoToursRegistration {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/newtours");

		// WebElement business = driver.findElement(By.partialLinkText("Business"));
		// business.click();
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		List<WebElement> inputTag = driver.findElements(By.tagName("input"));
		System.out.println(inputTag.size());
		WebElement firstName = driver.findElement(By.name("firstName"));
		WebElement LastName = driver.findElement(By.name("lastName"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.id("userName"));
		WebElement address = driver.findElement(By.name("address1"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement postalCode = driver.findElement(By.name("postalCode"));
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement confirmpassword = driver.findElement(By.name("confirmPassword"));
		WebElement submit = driver.findElement(By.name("submit"));
		firstName.sendKeys("Archana");
		LastName.sendKeys("Prasannan");
		phone.sendKeys("1234567891");
		email.sendKeys("archa123@gmail.com");
		address.sendKeys("Attiyil");
		city.sendKeys("Alappuzha");
		state.sendKeys("Kerala");
		postalCode.sendKeys("688011");
		username.sendKeys("hello");
		password.sendKeys("test");
		confirmpassword.sendKeys("test");
		submit.click();
		driver.close();

	}

}
