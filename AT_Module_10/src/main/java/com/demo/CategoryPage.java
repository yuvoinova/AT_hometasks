package com.demo;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends Page {
	@FindBy(xpath = "//div[@class='product-container']")
	protected List<WebElement> products;
	protected HashMap<String, Integer> colorsAndAmountsInFacets;
	protected HashMap<String, Integer> colorsAndAmountsInListing;

	public List<WebElement> getProducts() {
		return products;
	}

	public HashMap<String, Integer> getColorsAndAmountsInFacets() {
		return colorsAndAmountsInFacets;
	}

	public HashMap<String, Integer> getColorsAndAmountsInListing() {
		return colorsAndAmountsInListing;
	}

	public CategoryPage(WebDriver driver) {
		super(driver);
		parseColorsAmountsInFacets();
		parseColorsAmountsInListing();
	}

	private void parseColorsAmountsInFacets() {
		colorsAndAmountsInFacets = new HashMap<String, Integer>();
		String colorXPath = "//div[@class='layered_filter']//ul[contains(@class,'color-group')]/li";
		List<WebElement> colorsInFacetsElements = driver.findElements(By.xpath(colorXPath));
		for (WebElement colorInFacetsElement : colorsInFacetsElements) {
			WebElement colorStyleElement = colorInFacetsElement.findElement(By.xpath("./input"));
			String colorStyle = colorStyleElement.getAttribute("style");
			WebElement colorAmountElement = colorInFacetsElement.findElement(By.xpath("./label/a/span"));
			String colorSpanStr = colorAmountElement.getText();
			int colorAmount = Integer.parseInt(colorSpanStr.substring(1, colorSpanStr.length() - 1));
			colorsAndAmountsInFacets.put(colorStyle, colorAmount);
		}
	}

	private void parseColorsAmountsInListing() {
		colorsAndAmountsInListing = new HashMap<String, Integer>();
		String colorXPath = ".//div[@class='color-list-container']/ul/li/a";
		for (WebElement product : products) {
			List<WebElement> productColorElements = product.findElements(By.xpath(colorXPath));
			for (WebElement productColorElement : productColorElements) {
				String colorStyle = productColorElement.getAttribute("style");
				if (colorsAndAmountsInListing.containsKey(colorStyle)) {
					int previousColorAmount = colorsAndAmountsInListing.get(colorStyle);
					colorsAndAmountsInListing.put(colorStyle, previousColorAmount + 1);
				} else {
					colorsAndAmountsInListing.put(colorStyle, 1);
				}
			}
		}
	}

	public int getAmountOfColorsInFacets() {
		return colorsAndAmountsInFacets.size();
	}

	public int getAmountOfColorsInListing() {
		return colorsAndAmountsInListing.size();
	}
}
