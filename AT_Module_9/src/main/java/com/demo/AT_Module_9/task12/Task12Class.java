package com.demo.AT_Module_9.task12;

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

public class Task12Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/slider";
		driver.get(url);

		WebElement sliderField = driver.findElement(By.id("slider"));
		WebElement sliderHandle = driver.findElement(By.xpath("//div[@id='slider']/span"));
		System.out.println(sliderHandle.getLocation());

		Actions builder = new Actions(driver);
		int xOffset = sliderField.getSize().width / 2;
		builder.dragAndDropBy(sliderHandle, xOffset, 0).perform();
		System.out.println(sliderHandle.getLocation());

		xOffset = rnd(-sliderField.getSize().width / 2, sliderField.getSize().width / 2);
		builder.dragAndDropBy(sliderHandle, xOffset, 0).perform();
		System.out.println(sliderHandle.getLocation());
		
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task12/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();

	}

	private static int rnd(int min, int max) {
		return (int) (Math.random() * (max - min)) + min;
	}

}
