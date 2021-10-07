package TestNG.Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SeleniumCommands {
	public WebDriver driver;

	public void testInitialize(String browserName) throws Exception {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\SeleniumFiles\\DriverFiles\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\SeleniumFiles\\DriverFiles\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\SeleniumFiles\\DriverFiles\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}

	/*@BeforeMethod
	//@Parameters({"browser","url"})
	public void setUp(String browserName,String websiteUrl) throws Exception {
		// System.out.println("This is after method");
		testInitialize("chrome");
		//driver.get(websiteUrl);
	}*/
	@BeforeMethod
	
	public void setUp() throws Exception {
		testInitialize("chrome");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
		}
		driver.close();

		//System.out.println("This is after method");
	}

	// @BeforeSuite
	public void suiteSetup() {
		System.out.println("This is before suite");
	}

	// @AfterSuite
	public void suiteTearDown() {
		System.out.println("This is after suite");
	}

	// @BeforeTest
	public void testSetUp() {
		System.out.println("This is before Test");
	}

	// @AfterTest
	public void testTearDown() {
		System.out.println("This is after test");
	}

	//@BeforeClass
	public void classSetUp() {
		System.out.println("This is before class");
	}

	//@AfterClass
	public void classTearDown() {
		System.out.println("This is after class");
	}

	@Test(enabled = false)
	public void testMethod1() {
		System.out.println("Method 1");
	}

	@Test(enabled = false)
	public void testMethod2() {
		System.out.println("Method 2");
	}

	@Test(enabled = false)
	public void softAssert() {
		String expectedTitle = "Good Morning";
		String actualTitle = "Good afternoon";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid title");
		// Assert.assertEquals(actualTitle,expectedTitle,"Invalid title" );
		System.out.println("This is after assertion");
		softassert.assertAll();
	}

	@Test(enabled = false)
	public void verifyTitle() {
		driver.get("http://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Demo Web Shop";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid Title");
	}

	@Test(enabled = false, priority = 2,dataProvider="Credentials")
	public void verifyLogin(String userName,String Pass) {
		WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
		login.click();
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log in']"));
		email.sendKeys("userName");
		password.sendKeys("Pass");
		loginbutton.click();
		//WebElement actualEmail = driver.findElement(By.xpath("//a[text()='testhello12345@gmail.com']"));
		//String actualEmailtext = actualEmail.getText();
		//String expectedEmail = "testhello12345@gmail.com";
		//Assert.assertEquals(actualEmailtext, expectedEmail, "User Login Failed");

	}
	@DataProvider(name="Credentials")
	public Object[][] userCredentials()
	{
	Object[][] data=new Object[2][2];
	data[0][0]="archanaprasannan2014@gmail.com";
	data[0][1]="Mahadev@10";
	data[1][0]="pooja.ranjan@gmail.com";
	data[1][1]="password";
	return data;
	}

	@Test(priority = 1, enabled = false)
	public void verifyRegistration() {
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
		email.sendKeys("testhello12345@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("input[name=Password]"));
		password.sendKeys("hello@1234");
		WebElement confirmpassword = driver.findElement(By.cssSelector("input#ConfirmPassword"));
		confirmpassword.sendKeys("hello@1234");
		WebElement submit = driver.findElement(By.cssSelector("input[id=register-button]"));
		submit.click();
		WebElement actualusername = driver.findElement(By.xpath("//a[text()='testhello12345@gmail.com']"));
		String actualusernametext = actualusername.getText();
		String expectedusernametext = "testhello12345@gmail.com";
		Assert.assertEquals(actualusernametext, expectedusernametext, "User Registration failed");
	}

	@Test(enabled = false, priority = 1)
	public void verifySimpleAlert() {
		driver.get("https://demoqa.com/alerts");
		WebElement alertbutton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		alertbutton.click();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "You clicked a button";
		Assert.assertEquals(actualAlertText, expectedAlertText, "Ivalid Text");
		alert.accept();

	}

	@Test(enabled = false, priority = 2)
	public void verifyConfirmationAlert() {
		driver.get("https://demoqa.com/alerts");
		WebElement confirmationbutton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirmationbutton.click();
		Alert alert = driver.switchTo().alert();
		String actualalertText = alert.getText();
		String expectedalertText = "Do you confirm action?";
		Assert.assertEquals(actualalertText, expectedalertText, "Ivalid Text");
		alert.dismiss();
	}

	@Test(enabled = false, priority = 3)
	public void verifyPromptAlert() {
		driver.get("https://demoqa.com/alerts");
		WebElement alertButton = driver.findElement(By.id("promtButton"));
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		String actualalertText = alert.getText();
		String expectedalertText = "Please enter your name";
		Assert.assertEquals(actualalertText, expectedalertText, "Ivalid Text");
		alert.sendKeys("Archana");
		alert.accept();
	}

	@Test(enabled = false, priority = 1)
	public void verifysimpleAlert() {
		driver.get("https://selenium.obsqurazone.com/index.php");
		WebElement alertsAndModels = driver.findElement(By.id("alert-modal"));
		alertsAndModels.click();
		WebElement javaScriptElement = driver.findElement(By.linkText("Javascript Alert"));
		javaScriptElement.click();
		WebElement alertbox = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		alertbox.click();
		Alert alert = driver.switchTo().alert();
		String actualalertText = alert.getText();
		String expectedalertText = "I am a Javascript alert box!";
		Assert.assertEquals(actualalertText, expectedalertText, "Invalid Text");
		alert.accept();

	}

	@Test(enabled = false, priority = 2)
	public void verifyConfirmAlert() {
		driver.get("https://selenium.obsqurazone.com/index.php");
		WebElement alertsAndModels = driver.findElement(By.id("alert-modal"));
		alertsAndModels.click();
		WebElement javaScriptElement = driver.findElement(By.linkText("Javascript Alert"));
		javaScriptElement.click();
		WebElement confirmbox = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		confirmbox.click();
		Alert confirmalert = driver.switchTo().alert();
		String actualConfirmAlertText = confirmalert.getText();
		String expectedConfirmAlertText = "Press a button!";
		Assert.assertEquals(actualConfirmAlertText, expectedConfirmAlertText, "Invalid Text");
		confirmalert.accept();

	}

	@Test(enabled = false, priority = 3)
	public void verifyPromptalert() {
		driver.get("https://selenium.obsqurazone.com/index.php");
		WebElement alertsAndModels = driver.findElement(By.id("alert-modal"));
		alertsAndModels.click();
		WebElement javaScriptElement = driver.findElement(By.linkText("Javascript Alert"));
		javaScriptElement.click();
		WebElement promptbox = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		promptbox.click();
		Alert promptalert = driver.switchTo().alert();
		String actualPromptAlertText = promptalert.getText();
		String expectedPromptAlertText = "Please enter your name";
		Assert.assertEquals(actualPromptAlertText, expectedPromptAlertText, "invalid Text");
		promptalert.sendKeys("Archana");
		promptalert.accept();
	}

	@Test(enabled = false)
	public void verifyFileUpload() {
		driver.get("http://demo.guru99.com/test/upload/");
		WebElement chooseElement = driver.findElement(By.name("uploadfile_0"));
		chooseElement.sendKeys("D:\\SeleniumFiles\\SampleFiles\\Sample.txt.txt");
		WebElement terms = driver.findElement(By.id("terms"));
		terms.click();
		WebElement submit = driver.findElement(By.id("submitbutton"));
		submit.click();

	}

	@Test(enabled = false)
	public void verifyMultipleWindowHandling() {
		driver.get("http://demo.guru99.com/popup.php");
		String parentWindow = driver.getWindowHandle();
		// System.out.println(parentWindow);
		WebElement clickbutton = driver.findElement(By.linkText("Click Here"));
		clickbutton.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			// System.out.println(itr.next());
			String childWindow = itr.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
				email.sendKeys("archa123@gmail.com");
				WebElement submit = driver.findElement(By.name("btnLogin"));
				submit.click();
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);

	}

	@Test(enabled = false)
	public void verifyCloseAndQuit() {
		driver.get("http://demo.guru99.com/popup.php");
		WebElement clickbutton = driver.findElement(By.linkText("Click Here"));
		clickbutton.click();
		driver.quit();
	}

	@Test(enabled = false)
	public void verifyDropDown() {
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(country);
		// select.selectByVisibleText("INDIA");
		// select.selectByIndex(10);
		// select.selectByValue("INDIA");
		List<WebElement> countryList = select.getOptions();
		System.out.println(countryList.size());
		List<String> expectedCountryList = new ArrayList<String>();
		expectedCountryList.add("ALBANIA");
		expectedCountryList.add("ALGERIA");
		expectedCountryList.add("AMERICAN SAMOA");
		expectedCountryList.add("ANDORRA");
		expectedCountryList.add("ANGOLA");
		List<String> actualCountryList = new ArrayList<String>();
		// for(int i=0;i<countryList.size();i++)
		for (int i = 0; i < 5; i++) {
			actualCountryList.add(countryList.get(i).getText());
		}
		Assert.assertEquals(actualCountryList, expectedCountryList, "Invalid DropDown Value");
	}

	@Test(enabled = false)
	public void verifySingleInputField() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement message = driver.findElement(By.id("single-input-field"));
		message.sendKeys("Good Morning!!");
		WebElement showMessage = driver.findElement(By.id("button-one"));
		showMessage.click();
		WebElement messageText = driver.findElement(By.id("message-one"));
		String actualText = messageText.getText();
		String expectedText = "Your Message : Good Morning!!";
		Assert.assertEquals(actualText, expectedText, "Invalid Text Message");
	}

	@Test(enabled = false)
	public void verifyTwoInputField() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement valueA = driver.findElement(By.id("value-a"));
		valueA.sendKeys("10");
		WebElement valueB = driver.findElement(By.id("value-b"));
		valueB.sendKeys("20");
		WebElement total = driver.findElement(By.id("button-two"));
		total.click();
		WebElement totalText = driver.findElement(By.id("message-two"));
		String actualText = totalText.getText();
		String expectedText = "Total A + B : 30";
		Assert.assertEquals(actualText, expectedText, "Invalid Text Message");
	}

	@Test(enabled = false)
	public void verifySingleCheckBox() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement singleCheckBox = driver.findElement(By.className("form-check-label"));
		singleCheckBox.click();
		if (singleCheckBox.isSelected()) {
			Assert.assertTrue(true);
			WebElement textMessage = driver.findElement(By.id("message-one"));
			String actualText = textMessage.getText();
			String expectedText = "Success - Check box is checked";
			Assert.assertEquals(actualText, expectedText, "Invalid Text");
		}

	}

	@Test(enabled = false)
	public void verifyMultipleCheckBox() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement checkBoxOne = driver.findElement(By.id("check-box-one"));
		WebElement checkBoxTwo = driver.findElement(By.id("check-box-two"));
		WebElement checkBoxThree = driver.findElement(By.id("check-box-three"));
		WebElement checkBoxFourth = driver.findElement(By.id("check-box-four"));
		checkBoxOne.click();
		checkBoxTwo.click();
		boolean checkBoxOnestatus = checkBoxOne.isSelected();
		boolean checkBoxTwostatus = checkBoxTwo.isSelected();
		Assert.assertTrue(checkBoxOnestatus, "checkBoxOne not selected");
		Assert.assertTrue(checkBoxTwostatus, "CheckBoxTwo not selected");

		WebElement selectAll = driver.findElement(By.xpath("//input[@value='Select All']"));
		selectAll.click();
		boolean checkBoxOneStatus = checkBoxOne.isSelected();
		boolean checkBoxTwoStatus = checkBoxTwo.isSelected();
		boolean checkBoxThreeStatus = checkBoxThree.isSelected();
		boolean checkBoxFourStatus = checkBoxFourth.isSelected();
		Assert.assertTrue(checkBoxOneStatus, "checkBoxOne not selected");
		Assert.assertTrue(checkBoxTwoStatus, "checkBoxTwo not selected");
		Assert.assertTrue(checkBoxThreeStatus, "checkBoxThree not selected");
		Assert.assertTrue(checkBoxFourStatus, "checkBoxFour not selected");

		WebElement unSelectAll = driver.findElement(By.xpath("//input[@value='Unselect All']"));
		unSelectAll.click();
		boolean checkBoxoneStatus = checkBoxOne.isSelected();
		boolean checkBoxtwoStatus = checkBoxTwo.isSelected();
		boolean checkBoxthreeStatus = checkBoxThree.isSelected();
		boolean checkBoxfourStatus = checkBoxFourth.isSelected();
		Assert.assertFalse(checkBoxoneStatus, "checkBoxOne is selected");
		Assert.assertFalse(checkBoxtwoStatus, "checkBoxTWo is selected");
		Assert.assertFalse(checkBoxthreeStatus, "checkBoxThree is selected");
		Assert.assertFalse(checkBoxfourStatus, "checkBoxFour is selected");
	}

	@Test(enabled = false)
	public void verifySingleDropDown() {
		driver.get("https://selenium.obsqurazone.com/select-input.php");
		WebElement color = driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select = new Select(color);
		select.selectByVisibleText("Green");
		WebElement textMessage = driver.findElement(By.id("message-one"));
		String actualText = textMessage.getText();
		String expectedText = "Selected Color : Green";
		Assert.assertEquals(actualText, expectedText, "Invalid Text");

	}

	@Test(enabled = false)
	public void verifyMultipleDropDown() {
		driver.get("https://selenium.obsqurazone.com/select-input.php");
		WebElement color = driver.findElement(By.id("multi-select-field"));
		Select select = new Select(color);
		if (select.isMultiple()) {
			select.selectByValue("Red");
			select.selectByValue("Green");

		}
		WebElement selectAll = driver.findElement(By.id("button-all"));
		selectAll.click();
		WebElement textMessage = driver.findElement(By.className("my-2"));
		String actualText = textMessage.getText();
		String expectedText = "All selected colors are : Red,Green";
		Assert.assertEquals(actualText, expectedText, "Invalid Text");

	}

	@Test(enabled = false)
	public void verifyDropDownFromExcel() throws IOException {

		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(country);
		List<WebElement> countryList = select.getOptions();
		List<String> actualCountryList = new ArrayList<String>();
		for (int i = 0; i < countryList.size(); i++) {
			actualCountryList.add(countryList.get(i).getText());

		}
		List<String> expectedCountryList = ExcelUtility.getStringValue();
		Assert.assertEquals(actualCountryList, expectedCountryList, "Invalid Text Data");

	}

	@Test(enabled = false)
	public void verifyDoubleClick() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		// doubleClickButton.click();
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClickButton).build().perform();
		Alert alert = driver.switchTo().alert();
		String actualTextMessage = alert.getText();
		String expectedTextMessage = "You double clicked me.. Thank You..";
		Assert.assertEquals(actualTextMessage, expectedTextMessage, "Invalid Text");
		alert.accept();
	}

	@Test(enabled = false)
	public void verifyRightClickCopyButton() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickButton = driver
				.findElement(By.cssSelector("span[class='context-menu-one btn btn-neutral']"));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClickButton).build().perform();
		WebElement copyButton = driver
				.findElement(By.cssSelector("li[class='context-menu-item context-menu-icon context-menu-icon-copy']"));
		actions.click(copyButton).build().perform();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "clicked: copy";
		Assert.assertEquals(actualText, expectedText, "Invalid Text");
		alert.accept();
	}

	@Test(enabled = false)
	public void verifyRightClickEditButton() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickButton = driver
				.findElement(By.cssSelector("span[class='context-menu-one btn btn-neutral']"));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClickButton).build().perform();
		WebElement editButton = driver
				.findElement(By.cssSelector("li[class='context-menu-item context-menu-icon context-menu-icon-edit']"));
		actions.click(editButton).build().perform();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "clicked: edit";
		Assert.assertEquals(actualText, expectedText, "Invalid Text");
		alert.accept();

	}

	@Test(enabled = false)
	public void verifyMenusFromExcel() throws IOException {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickButton = driver
				.findElement(By.cssSelector("span[class='context-menu-one btn btn-neutral']"));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClickButton).build().perform();
		List<WebElement> context = driver.findElements(By.xpath(
				"//ul[@class='context-menu-list context-menu-root']//li[contains(@class,'context-menu-item context-menu-icon context-menu-icon')]"));
		List<String> actualContextValues = new ArrayList<String>();
		for (int i = 0; i < context.size(); i++) {
			actualContextValues.add(context.get(i).getText());
		}
		for (String str : actualContextValues) {
			System.out.println("vlues:" + str);
		}
		List<String> expectedContextValues = ExcelContext.getContextValue();
		System.out.println("list:" + expectedContextValues);
		Assert.assertEquals(actualContextValues, expectedContextValues, "Invalid data");
	}

	@Test(enabled = false)
	public void verifyDragAndDrop() {
		driver.get("https://demoqa.com/droppable");
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragElement, dropElement).build().perform();
	}

	@Test(enabled = false)
	public void verifyDragAndDropBy() {
		driver.get("https://demoqa.com/dragabble");
		WebElement dragElement = driver.findElement(By.id("dragBox"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(dragElement).dragAndDropBy(dragElement, 100, 100).build().perform();
	}

	@Test(enabled = false)
	public void verifyMoveToElement() throws InterruptedException {
		driver.get("https://demoqa.com/menu/");
		List<WebElement> menuItem = driver.findElements(By.xpath("//ul[@id='nav']//a"));
		for (int i = 0; i < menuItem.size(); i++) {
			if (menuItem.get(i).getText().equals("Main Item 2")) {
				Actions actions = new Actions(driver);
				actions.moveToElement(menuItem.get(i)).build().perform();

				for (int j = i; j < menuItem.size(); j++) {
					if (menuItem.get(j).getText().equals("SUB SUB LIST")) {
						actions.moveToElement(menuItem.get(j)).build().perform();
						for (int k = j; k < menuItem.size(); k++) {
							if (menuItem.get(k).getText().equals("Sub Sub Item 1")) {
								actions.moveToElement(menuItem.get(k)).build().perform();
							}
						}
					}
				}

			}
		}
	}

	@Test(enabled = false)
	public void seleniumWaits() {
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.className("ico-login"));
		login.click();
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("archanaprasannan2014@gmail.com");
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("test@123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='button-1 login-button']")));// login
																														// locator
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginButton.click();

	}

	@Test(enabled = false)
	public void fluentWait() {
		driver.get("https://www.canva.com/login");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("_38oWvQ"));
		Wait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		email.sendKeys("Archana@gmail.com");
		password.sendKeys("test@123");
		login.click();

	}

	@Test(enabled = false)
	public void implicitlyWait() {
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("Archana123");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("test123");
		WebElement login = driver.findElement(By.name("submit"));
		login.click();
	}

	@Test(enabled = false)
	public void pageLoadTimeOutWait() {
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("Archana123");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("test123");
		WebElement login = driver.findElement(By.name("submit"));
		login.click();
	}

	@Test(enabled = false)
	public void explicitWait() {
		driver.get("https://www.canva.com/login");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement login = driver.findElement(By.name("_38oWvQ"));
		wait.until(ExpectedConditions.visibilityOf(email));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		email.sendKeys("Archana@gmail.com");
		password.sendKeys("test@123");
		login.click();
	}

	@Test(enabled = false)
	public void keyboardActions() throws InterruptedException {
		driver.get("http://demowebshop.tricentis.com/");
		WebElement login = driver.findElement(By.className("ico-login"));
		login.click();
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("archanaprasannan2014@gmail.com");
		Thread.sleep(3000);
		// email.clear();
		email.sendKeys(Keys.CONTROL + "A");
		email.sendKeys(Keys.DELETE);
	}

	@Test(enabled = false)
	public void robotClass() throws AWTException, InterruptedException {
		driver.get("http://demowebshop.tricentis.com/");
		WebElement login = driver.findElement(By.className("ico-login"));
		login.click();
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("archanaprasannan2014@gmail.com");
		WebElement password = driver.findElement(By.id("Password"));

		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		password.sendKeys("test@123");
		loginButton.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

	@Test(enabled = false)
	public void staleElementException() {
		driver.get("http://demowebshop.tricentis.com/");
		WebElement login = driver.findElement(By.className("ico-login"));
		login.click();
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		driver.navigate().refresh();
		email.sendKeys("archanaprasannan2014@gmail.com");

	}

	@Test(enabled = false)
	public void javaScriptExecutor() {
		driver.get("http://demowebshop.tricentis.com/login");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('newsletter-email').value='test@gmail.com'");
		js.executeScript("document.getElementById('newsletter-subscribe-button').click()");

	}

	@Test(enabled = false)
	public void scroll() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		// table[@id='customers']//tr[5]//td

	}

	@Test(enabled = false)
	public void verifyTableExcelValue() throws IOException {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> TableText = driver.findElements(By.xpath("//table[@id='customers']//tr[5]//td"));
		List<String> actualTableText = new ArrayList<String>();
		for (int i = 0; i < TableText.size(); i++) {
			actualTableText.add(TableText.get(i).getText());
		}

		List<String> expectedTableText = ExcelTable.excelTable();
		Assert.assertEquals(actualTableText, expectedTableText, "invalid Text");
	}

	@Test(enabled = false)
	public void dynamicTable() throws IOException {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='customers']//tr//td"));
		List<String> expectedTableText = ExcelTable.excelTable();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getText().equals("Island Trading")) {
				List<WebElement> tradingList = driver
						.findElements(By.xpath("//table[@id='customers']//tr[" + i + "]//td"));
				Assert.assertEquals(tradingList, expectedTableText, "Data not found in table");
			}

		}
	}

	@Test(enabled = false)
	public void tableElement() {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		List<WebElement> columnItem = driver.findElements(By.xpath("//table[@id='customers']//tr//td"));
		List<WebElement> rowItem = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		List<ArrayList<String>> gridData = WebTableUtility.get_Dynamic_TwoDimension_TablElemnts(rowItem, columnItem);
		System.out.println(gridData);
	}

	@Test(enabled = false)
	public void dropDownOtherThanSelectTag() {

	}
	
	@Test(enabled = true)
	public void verifyFrames()
	{
		driver.get("https://demoqa.com/frames");
		//WebElement frame=driver.findElement(By.cssSelector("iframe#frame1"));
		//driver.switchTo().frame(frame);
		//driver.switchTo().frame("frame1");
		driver.switchTo().frame(1);
		WebElement text=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		String actualText=text.getText();
		System.out.println(actualText);
		driver.switchTo().parentFrame();
		//driver.switchTo().defaultContent(); Switch to parent
	}
	public void verifywindowhandle()
	{
		driver.get("https://demoqa.com/browser-windows");
		WebElement newtab=driver.findElement(By.id("tabButton"));
		String parentWindow=driver.getWindowHandle();
		newtab.click();
		Set<String>handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		while(itr.hasNext())
		{
			String childwindow=itr.next();
			if(!parentWindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				WebElement text=driver.findElement(By.id("sampleHeading"));
				String actualtextvalue=text.getText();
				String expected="This is a sample page";
				Assert.assertEquals(actualtextvalue, expected,"invalid");
				
			}
		}
		driver.switchTo().window(parentWindow);
				
	}
}
