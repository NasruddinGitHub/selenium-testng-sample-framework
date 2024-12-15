package com.citibank.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
	
	private static final By PRODUCTS_LABEL = By.className("product_label");
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isProductsLabelDisplayed() {
		return isElementDisplayed(PRODUCTS_LABEL, BasePage.MEDIUM_WAIT_TIME);
	}
	
}
