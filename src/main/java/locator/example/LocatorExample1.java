package locator.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorExample1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.canva.com/");
		WebElement login = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/header/div[5]/button[1]/span"));
		login.click();
		driver.manage().deleteAllCookies();

		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));

		email.sendKeys("archanaprasannan2014@gmail.com");
		password.sendKeys("Ganesh@10");
		WebElement loginButton = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div.NqU4Yg > div > div > div > div > div.EYTKnA > div > div > div > div > div > div > div > div > div > div > div > div.FOI5hA > form > button > span"));
		loginButton.click();

		driver.close();
	}

}
