package com.demo.AT_Module_9.task8;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task8Class {

	public static void main(String[] args) throws Throwable {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/selectable";
		driver.get(url);

		WebElement h1 = driver.findElement(By.className("entry-title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", h1);

		List<WebElement> lis = driver.findElements(By.xpath("//ol[@id='selectable']/li"));

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");

		int random;
		for (int i = 0; i < 3; i++) {
			random = new Random().nextInt(lis.size());
			lis.get(random).click();
			String path = "./target/screenshots/Task8/Screenshot" + (i + 1) + "_" + formatForDateNow.format(dateNow)
					+ ".png";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(path));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		driver.quit();

	}

}
