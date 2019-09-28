package com.demo.AT_Module_9.task7;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task7Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/sortable";
		driver.get(url);

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='demo-frame']//li"));
		if (isSorted(items)) {
			System.out.println("All items are sorted correctly");
			WebElement from = items.get(1);
			int yOffset = items.get(4).getLocation().y - items.get(1).getLocation().y + 1;
			Actions act = new Actions(driver);
			act.dragAndDropBy(from, 0, yOffset).build().perform();
		} else {
			System.out.println("Items are not sorted correctly");
		}

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task7/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}

	private static boolean isSorted(List<WebElement> items) {
		if (items.size() < 2) {
			return true;
		}
		for (int i = 0; i < items.size() - 1; i++) {
			if (items.get(i).getText().compareTo(items.get(i + 1).getText()) > 0) {
				return false;
			}
		}
		return true;
	}

}
