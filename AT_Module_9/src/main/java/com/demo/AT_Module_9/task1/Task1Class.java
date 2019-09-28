package com.demo.AT_Module_9.task1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String URL = "https://www.facebook.com";
		driver.get(URL);

		CharSequence[] login = new CharSequence[] { "honey.tester@inbox.ru" };
		CharSequence[] password = new CharSequence[] { "123qweQWE" };
		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.clear();
		emailInput.sendKeys(login);
		WebElement passwordInput = driver.findElement(By.id("pass"));
		passwordInput.clear();
		passwordInput.sendKeys(password);
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		loginButton.click();
		try {
			driver.findElement(By.className("imgWrap"));
			System.out.println("Test passed");
		} catch (NoSuchElementException e) {
			System.out.println("Test failed");
		}
		
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task1/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		driver.quit();
	}
}