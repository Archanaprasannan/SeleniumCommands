package locator.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShopRegistrationCssSelector {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demowebshop.tricentis.com/");
		WebElement register = driver.findElement(By.cssSelector("a.ico-register"));
		register.click();
		List<WebElement> genders = driver.findElements(By.cssSelector("div.gender"));
		for (int i = 0; i < genders.size(); i++) {
			String gender = genders.get(i).getText();
			if (gender.equals("Female")) {
				genders.get(i).click();
			}
		}
		WebElement firstName = driver.findElement(By.cssSelector("input#FirstName"));
		firstName.sendKeys("Archana");
		WebElement lastName = driver.findElement(By.cssSelector("input[name=LastName]"));
		lastName.sendKeys("Prasannan");
		WebElement email = driver.findElement(By.cssSelector("input#Email"));
		email.sendKeys("archa567@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("input[name=Password]"));
		password.sendKeys("test123");
		WebElement confirmpassword = driver.findElement(By.cssSelector("input#ConfirmPassword"));
		confirmpassword.sendKeys("test123");
		WebElement submit = driver.findElement(By.cssSelector("input[id=register-button]"));
		submit.click();
		driver.close();

	}

}
