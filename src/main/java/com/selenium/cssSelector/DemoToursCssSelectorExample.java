package com.selenium.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoToursCssSelectorExample {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://demo.guru99.com/test/newtours/");
	WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
	register.click();
	WebElement firstName=driver.findElement(By.cssSelector("input[name=firstName]"));
	firstName.sendKeys("Archana");
	WebElement lastName=driver.findElement(By.cssSelector("input[name=lastName]"));
	lastName.sendKeys("Prasannan");
	WebElement phone=driver.findElement(By.cssSelector("input[name=phone]"));
	phone.sendKeys("234567810");
	WebElement email=driver.findElement(By.cssSelector("input#userName"));
	email.sendKeys("archa123@gmail.com");
	WebElement address=driver.findElement(By.cssSelector("input[name=address1]"));
	address.sendKeys("Attiyil");
	WebElement city=driver.findElement(By.cssSelector("input[name=city]"));
	city.sendKeys("Alappuzha");
	WebElement state=driver.findElement(By.cssSelector("input[name=state]"));
	state.sendKeys("Kerala");
	WebElement postal=driver.findElement(By.cssSelector("input[name=postalCode]"));
	postal.sendKeys("688011");
	WebElement username=driver.findElement(By.cssSelector("input#email"));
	username.sendKeys("Archa123");
	WebElement password=driver.findElement(By.cssSelector("input[name=password]"));
	password.sendKeys("test123");
	WebElement confirmpassword=driver.findElement(By.cssSelector("input[name=confirmPassword]"));
	confirmpassword.sendKeys("test123");
	WebElement submit=driver.findElement(By.cssSelector("input[name=submit]"));
	submit.click();
	
	
	
}
}
