package com.demo.AT_Module_9.task4;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "http://demo.guru99.com/popup.php";
		driver.get(url);
		String ParentWindowHandle = driver.getWindowHandle();

		driver.findElement(By.linkText("Click Here")).click();

		String ChildWindowHandle = "";
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(ParentWindowHandle)) {
				ChildWindowHandle = handle;
			}
		}

		CharSequence[] emailId = new CharSequence[] { "honey.tester@inbox.ru" };
		driver.switchTo().window(ChildWindowHandle);
		driver.findElement(By.name("emailid")).sendKeys(emailId);
		driver.findElement(By.name("btnLogin")).submit();
		
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task4/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		driver.close();
		driver.switchTo().window(ParentWindowHandle);
		driver.close();
	}

}
