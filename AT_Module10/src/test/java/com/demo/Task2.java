package com.demo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Waiters;

public class Task2 {
	private static ChromeDriver chromeDriver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		chromeDriver = new ChromeDriver();
		Waiters.waitImplicit(chromeDriver, 3, TimeUnit.SECONDS);
		chromeDriver.get(MainPage.PAGE_URL);
	}

	@Test
	public void testWomenCategory() {
//		GIVEN
		MainPage mainPage = new MainPage(chromeDriver);
//		WHEN
		WomenCategoryPage womenCategoryPage = mainPage.goToWomenCategory();
//		THEN
		assertEquals(womenCategoryPage.getAmountOfColorsInFacets(), womenCategoryPage.getAmountOfColorsInListing());
	}

	@Test
	public void testDressesCategory() {
//		GIVEN
		MainPage mainPage = new MainPage(chromeDriver);
//		WHEN
		DressesCategoryPage dressesCategoryPage = mainPage.goToDressesCategory();
//		THEN
		assertEquals(dressesCategoryPage.getAmountOfColorsInFacets(), dressesCategoryPage.getAmountOfColorsInListing());
	}

	@After
	public void tearDown() throws Exception {
		chromeDriver.close();
	}
}
