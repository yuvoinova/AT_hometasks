package com.demo.AT_Module_9.task10;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task10Class {

	public static void main(String[] args) {
		boolean isPassed = true;

		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/tooltip-and-double-click";
		driver.get(url);

		Actions builder = new Actions(driver);
		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
		builder.doubleClick(doubleClickButton).perform();

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Test faild");
			isPassed = false;
		}

		driver.navigate().refresh();

		WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
		builder.contextClick(rightClickButton).perform();

		if (!driver.findElement(By.id("rightclickItem")).isDisplayed()) {
			System.out.println("Test faild");
			isPassed = false;
		}

		driver.navigate().refresh();

		WebElement tooltipDemo = driver.findElement(By.id("tooltipDemo"));
		builder.moveToElement(tooltipDemo).perform();

		if (!driver.findElement(By.xpath("//span[@class='tooltiptext']")).isDisplayed()) {
			System.out.println("Test faild");
			isPassed = false;
		}

		if (isPassed) {
			System.out.println("Test passed");
		}

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task10/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();

	}

}
