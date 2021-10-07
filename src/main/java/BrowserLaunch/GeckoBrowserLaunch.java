package BrowserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoBrowserLaunch {

	public static void main(String[] args) {
		
System.setProperty("webdriver.gecko.driver", "D:\\SeleniumFiles\\DriverFiles\\geckodriver-v0.29.1-win64\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.get("https://www.google.com/");

	}

}
