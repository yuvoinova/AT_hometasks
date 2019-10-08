package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

	public static final int WAIT_60 = 60;
	public static final int WAIT_10 = 10;

	public static void waitImplicit(WebDriver driver, int time, TimeUnit timeUnit) {
		driver.manage().timeouts().implicitlyWait(time, timeUnit);
	}

	public static void waitForElement(WebDriver driver, WebElement element, int maxTimeSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
