package BrowserLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserLaunch {

	public static void main(String[] args) {
		//set the system properties of chrome driver and specifying the path to it. 
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		//creating object to instantiate driver
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//used to open an URL and it will wait till the whole page gets loaded.
		driver.get("http://demo.guru99.com/test/newtours/");
	    String pageSource=	driver.getPageSource();
	   // System.out.println(pageSource);
	    String currentUrl=  driver.getCurrentUrl();
	    //System.out.println(currentUrl);
	    String title=driver.getTitle();
	    //System.out.println(title);
	    WebElement userName=driver.findElement(By.name("userName"));
	    WebElement password=driver.findElement(By.name("password"));
	    WebElement loginButton=driver.findElement(By.name("submit"));
	    userName.sendKeys("Test");
	    password.sendKeys("test");
	    loginButton.click();
		driver.close();
		
		
	}

}
