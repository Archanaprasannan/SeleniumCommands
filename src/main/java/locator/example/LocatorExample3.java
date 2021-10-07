package locator.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorExample3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(
				"https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		WebElement email = driver.findElement(By.name("identifier"));
		WebElement next = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		email.sendKeys("archanaprasannan2014@gmail.com");
		next.click();
		WebElement password = driver.findElement(By.className("whsOnd zHQkBf"));
		WebElement loginNext = driver.findElement(By.className("VfPpkd-vQzf8d"));

		password.sendKeys("Mahadev@10");
		loginNext.click();
	}

}
