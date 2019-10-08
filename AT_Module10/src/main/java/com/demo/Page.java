package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Waiters;

public class Page {
	protected WebDriver driver;
	@FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li[1]")
	protected WebElement womenCategory;
	@FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li[2]")
	protected WebElement dressesCategory;
	@FindBy(xpath = "//section[contains(@class,'bottom-footer')]")
	protected WebElement bottomFooter;

	protected Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Waiters.waitForElement(driver, bottomFooter, Waiters.WAIT_60);
	}

	public WomenCategoryPage goToWomenCategory() {
		womenCategory.click();
		return new WomenCategoryPage(driver);
	}

	public DressesCategoryPage goToDressesCategory() {
		dressesCategory.click();
		return new DressesCategoryPage(driver);
	}
}
