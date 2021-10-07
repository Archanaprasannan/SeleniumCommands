package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoToursRegistrationXpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement register = driver.findElement(By.xpath("//a[text()='REGISTER']"));
		register.click();

		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		WebElement phone = driver.findElement(By.xpath("//input[@name='phone' and @size='15']"));
		WebElement email = driver.findElement(By.xpath("//input[@name='userName' and @id='userName']"));
		WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement state = driver.findElement(By.xpath("//input[contains(@name,'sta')]"));
		WebElement postalCode = driver.findElement(By.xpath("//input[contains(@name,'po')]"));
		WebElement userName = driver.findElement(By.xpath("//input[contains(@id,'ema')]"));
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@name,'pass')]"));
		WebElement confirmpassword = driver.findElement(By.xpath("//input[starts-with(@name,'con')]"));
		firstName.sendKeys("Archana");
		lastName.sendKeys("Prasannan");
		phone.sendKeys("123456786");
		email.sendKeys("archa@gmail.com");
		address.sendKeys("Attiyil");
		city.sendKeys("Alappuzha");
		state.sendKeys("kerala");
		postalCode.sendKeys("688011");
		userName.sendKeys("archa123");
		password.sendKeys("test");
		confirmpassword.sendKeys("test");
		WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
		submit.click();
		driver.close();

	}

}
