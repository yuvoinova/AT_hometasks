package com.demo;

import org.openqa.selenium.WebDriver;

public class DressesCategoryPage extends CategoryPage {
	public static final String PAGE_URL = "http://automationpractice.com/index.php?id_category=8&controller=category";

	public DressesCategoryPage(WebDriver driver) {
		super(driver);
	}
}
