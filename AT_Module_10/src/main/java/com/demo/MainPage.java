package com.demo;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
	public static final String PAGE_URL = "http://automationpractice.com/index.php";

	public MainPage(WebDriver driver) {
		super(driver);
	}
}
