package com.demo.AT_Module_9.task9;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task9Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/resizable";
		driver.get(url);

		WebElement rectangle = driver.findElement(By.id("resizable"));
		System.out.println(rectangle.getSize());
		WebElement rectangleAngle = driver.findElement(By.xpath("//div[contains(@class, 'ui-icon')]"));

		Actions builder = new Actions(driver);
		builder.clickAndHold(rectangleAngle).moveByOffset(100, 100).release().click().perform();
		System.out.println(rectangle.getSize());

		builder.clickAndHold(rectangleAngle).moveByOffset(-50, -50).release().click().perform();
		System.out.println(rectangle.getSize());

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task9/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();

	}

}
