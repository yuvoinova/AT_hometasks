package com.demo.AT_Module_9.task2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String URL = "https://en.wikipedia.org";
		driver.get(URL);

		java.util.List<WebElement> links = driver.findElements(By.xpath("//div[@id='mp-itn']/ul//a"));
		links.get(0).click();

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		Dimension dimension = new Dimension(200, 500);
		driver.manage().window().setSize(dimension);

		Point point = new Point(300, 250);
		driver.manage().window().setPosition(point);

		driver.manage().window().maximize();
		
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task2/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		driver.quit();
	}

}
