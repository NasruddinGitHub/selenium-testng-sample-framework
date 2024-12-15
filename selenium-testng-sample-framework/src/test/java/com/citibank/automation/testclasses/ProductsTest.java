package com.citibank.automation.testclasses;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.citibank.automation.pages.LoginPage;
import com.citibank.automation.pages.ProductsPage;
import com.citibank.automation.utilities.ReportUtil;

public class ProductsTest extends BaseTest {

	@Parameters(value = { "username", "password" })
	@Test(description = "Validate whether the products are shown in ascending oder by name when user navigates to products screen")
	public void validateIfProductsAreShownInAscedingOrderByNameByDefault(String username, String password) {
		ReportUtil.createTest("Login with valid username and password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		ReportUtil.info("User is logged into the system");
		ProductsPage productsPage = new ProductsPage(driver);
		String selectedProductSorting = productsPage.getSelectedProductSorting();
		Assert.assertEquals(selectedProductSorting, "Name (A to Z)");
		ReportUtil.info("Assertion is completed for ascending order test");
	}

}
