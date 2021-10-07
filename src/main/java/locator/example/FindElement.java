package locator.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demowebshop.tricentis.com/register");
		// List<WebElement> genders =
		// driver.findElements(By.xpath("//input[contains(@id,'gender')]"));
		// System.out.println(genders);
		List<WebElement> genders = driver.findElements(By.xpath("//label[contains(@class,'forcheckbox')]"));
		System.out.println(genders);
		for (int i = 0; i < genders.size(); i++) {
			String gender = genders.get(i).getText();
			if (gender.equals("Female")) {
				genders.get(i).click();
			}
		}
		driver.close();
	}

}
