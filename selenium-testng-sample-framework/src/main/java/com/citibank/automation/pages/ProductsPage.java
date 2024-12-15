package com.citibank.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

	private static final By PRODUCTS_LABEL = By.className("product_label");
	private static final By PRODUCT_SORT_CONTAINER = By.className("product_sort_container");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isProductsLabelDisplayed() {
		return isElementDisplayed(PRODUCTS_LABEL, MEDIUM_WAIT_TIME);
	}

	public String getSelectedProductSorting() {
		return getText(PRODUCT_SORT_CONTAINER, MEDIUM_WAIT_TIME);
	}

}
