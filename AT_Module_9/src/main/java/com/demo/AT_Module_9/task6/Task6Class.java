package com.demo.AT_Module_9.task6;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class Task6Class {

	public static void main(String[] args) throws Throwable {
		String chromePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		google("aza", "Фарфор", chromeDriver);
		chromeDriver.navigate().refresh();
		google("aza", "depression", chromeDriver);
		chromeDriver.navigate().refresh();
		google("aza", "Карась", chromeDriver);
		chromeDriver.quit();

		String edgePath = "./src/main/resources/MicrosoftWebDriver.exe";
		System.setProperty("webdriver.chrome.driver", edgePath);
		WebDriver edgeDriver = new EdgeDriver();
		edgeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		google("aza", "Фарфор", edgeDriver);
		edgeDriver.navigate().refresh();
		google("aza", "depression", edgeDriver);
		edgeDriver.navigate().refresh();
		google("aza", "Карась", edgeDriver);
		edgeDriver.quit();
	}

	private static void google(String googleStr, String searchStr, WebDriver driver) throws Throwable {
		String url = "https://google.com";
		driver.get(url);
		int pageNumber = 0;
		boolean isFound = false;

		WebElement input = driver.findElement(By.name("q"));
		input.clear();
		CharSequence[] inputStr = new CharSequence[] { googleStr };
		input.sendKeys(inputStr);
		input.sendKeys(Keys.RETURN);

		while (!isFound) {
			pageNumber += 1;
			List<WebElement> results = driver.findElements(By.xpath("//div[@class='rc']"));
			for (WebElement result : results) {
				List<WebElement> test = result.findElements(By.xpath(".//*"));
				for (WebElement element : test) {
					if (element.getText().contains(searchStr)) {
						System.out.println("'" + searchStr + "' is found on " + pageNumber + " page");
						isFound = true;
						makeScreenshots(result, driver);
						return;
					}
				}
			}
			try {
				WebElement linkNext = driver.findElement(By.xpath("//table//td[last()]//span[not(@class)]"));
				linkNext.click();
			} catch (NoSuchElementException e) {
				if (!isFound) {
					System.out.println("'" + searchStr + "' is not found");
				}
				return;
			}
		}
	}

	private static void makeScreenshots(WebElement element, WebDriver driver) {
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");

		int yOffset = element.getLocation().y - element.getSize().height;
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + yOffset + ");");

		String pathBegin = "./target/screenshots/Task6/Screenshot" + formatForDateNow.format(dateNow) + "Begin.png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(pathBegin));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		WebElement navigate = driver.findElement(By.id("navcnt"));

		yOffset = navigate.getLocation().y;
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + yOffset + ");");

		String pathEnd = "./target/screenshots/Task6/Screenshot" + formatForDateNow.format(dateNow) + "End.png";
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(pathEnd));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
