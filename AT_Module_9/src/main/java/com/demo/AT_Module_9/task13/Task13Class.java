package com.demo.AT_Module_9.task13;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task13Class {

	public static void main(String[] args) throws Throwable {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/datepicker";
		driver.get(url);

		WebElement datePickerInput = driver.findElement(By.id("datepicker"));
		datePickerInput.clear();
		datePickerInput.click();

		WebElement datePickerMonth = driver.findElement(By.className("ui-datepicker-month"));
		WebElement datePickerYear = driver.findElement(By.className("ui-datepicker-year"));
		WebElement datePickerPrev = driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]"));

		while (!datePickerMonth.getText().equals("August") || !datePickerYear.getText().equals("2019")) {
			datePickerPrev.click();
			datePickerMonth = driver.findElement(By.className("ui-datepicker-month"));
			datePickerYear = driver.findElement(By.className("ui-datepicker-year"));
		}

		List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
		int random = new Random().nextInt(dates.size());
		dates.get(random).click();

		String pattern = "^(08).+(19)$";
		if (datePickerInput.getAttribute("value").matches(pattern)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task13/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}

}
