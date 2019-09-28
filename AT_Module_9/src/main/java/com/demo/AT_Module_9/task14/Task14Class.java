package com.demo.AT_Module_9.task14;

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

public class Task14Class {

	public static void main(String[] args) {
		String exePath = "./src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://demoqa.com/checkboxradio";
		driver.get(url);

		boolean isPassed = true;

		List<WebElement> locationLabels = driver.findElements(By.xpath("//fieldset[1]/label"));
		for (int i = 0; i < locationLabels.size(); i++) {
			locationLabels.get(i).click();
			isPassed = isPassed && locationLabels.get(i).getAttribute("class").contains("checked");
			for (int j = 0; j < locationLabels.size(); j++) {
				if (j != i) {
					isPassed = isPassed && (!locationLabels.get(j).getAttribute("class").contains("checked"));
				}
			}
		}

		List<WebElement> hotelRatingLabels = driver.findElements(By.xpath("//fieldset[2]/label"));
		for (int i = 0; i < hotelRatingLabels.size(); i++) {
			hotelRatingLabels.get(i).click();
			for (int j = 0; j <= i; j++) {
				isPassed = isPassed && hotelRatingLabels.get(j).getAttribute("class").contains("checked");
			}
		}

		if (isPassed) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String path = "./target/screenshots/Task14/Screenshot" + formatForDateNow.format(dateNow) + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}

}
