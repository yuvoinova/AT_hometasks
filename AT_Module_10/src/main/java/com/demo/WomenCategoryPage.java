package com.demo;

import org.openqa.selenium.WebDriver;

public class WomenCategoryPage extends CategoryPage {
	public static final String PAGE_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";

	public WomenCategoryPage(WebDriver driver) {
		super(driver);
	}
}
