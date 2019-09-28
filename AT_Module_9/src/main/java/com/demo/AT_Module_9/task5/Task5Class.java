package com.demo.AT_Module_9.task5;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task5Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/MicrosoftWebDriver.exe";
		System.setProperty("webdriver.edge.driver", exePath);
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = "https://en.wikipedia.org/wiki/Main_Page";
		driver.get(url);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i<links.size(); i++)
		{
			System.out.println(i+" " + links.get(i).getText()) ;
		}
		
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task5/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		driver.quit();
	}

}
