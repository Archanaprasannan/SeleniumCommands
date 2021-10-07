package com.Xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShopRegistrationXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demowebshop.tricentis.com/");
		WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
		register.click();
		List<WebElement> genders = driver.findElements(By.xpath("//label[contains(@class,'forcheckbox')]"));
		for (int i = 0; i < genders.size(); i++) {
			String gender = genders.get(i).getText();
			if (gender.equals("Female")) {
				genders.get(i).click();
				System.out.println(genders.get(i).isSelected());
			}

		}

		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@id,'LastNa')]"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@id,'Ema')]"));
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement confirmpassword = driver
				.findElement(By.xpath("//input[@id='ConfirmPassword' and @name='ConfirmPassword']"));

		firstName.sendKeys("Archana");
		lastName.sendKeys("Prasannan");
		email.sendKeys("Archa@gmail.com");
		password.sendKeys("test123");
		confirmpassword.sendKeys("test123");
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit' and @value='Register']"));
		submit.click();
		driver.close();

	}

}
