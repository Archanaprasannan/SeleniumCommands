package locator.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathFindElement2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demowebshop.tricentis.com/register");
		List<WebElement> genders = driver.findElements(By.xpath("//label[contains(@class,'for')]"));
		for (int i = 0; i < genders.size(); i++) {
			String gender = genders.get(i).getText();
			if (gender.equals("Female")) {
				genders.get(i).click();
			}
		}
		WebElement firstname = driver.findElement(By.id("FirstName"));
		WebElement lastname = driver.findElement(By.id("LastName"));
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement confirmpassword = driver.findElement(By.id("ConfirmPassword"));

		firstname.sendKeys("Archana");
		lastname.sendKeys("prasannan");
		email.sendKeys("Archa@gmail.com");
		password.sendKeys("test123");
		confirmpassword.sendKeys("test123");
		WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
		register.click();

	}

}
