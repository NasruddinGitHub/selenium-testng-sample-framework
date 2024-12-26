package com.citibank.automation.testclasses;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.citibank.automation.pages.LoginPage;
import com.citibank.automation.pages.ProductsPage;
import com.citibank.automation.utilities.ReportUtil;

public class LoginTest extends BaseTest {

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithValidCredentials(String username, String password) {
		ReportUtil.createTest("Login with valid username and password",
				"This test is used to check whether the user is able lo login with valid username or not");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ReportUtil.info("User is logged into the system");
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		ReportUtil.info("Is product label displayed? " + isProductsLabelDisplayed);
		Assert.assertTrue(isProductsLabelDisplayed);
		ReportUtil.info("Assertion is completed");
	}

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithValidUsernameAndInvalidPassword(String username, String password) {
		ReportUtil.createTest("Login with valid username and invalid password");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		Assert.assertFalse(isProductsLabelDisplayed);
	}

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithInvalidUsernameAndValidPassword(String username, String password) {
		ReportUtil.createTest("Login with invalid username and valid password");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		Assert.assertFalse(isProductsLabelDisplayed);
	}

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword(String username, String password) {
		ReportUtil.createTest("Login with invalid username and invalid password");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		Assert.assertFalse(isProductsLabelDisplayed);
	}

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithEmptyUsernameAndEmptyPassword(String username, String password) {
		ReportUtil.createTest("Login with empty username and empty password");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		Assert.assertFalse(isProductsLabelDisplayed);
	}

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithEmptyUsernameAndValidPassword(String username, String password) {
		ReportUtil.createTest("Login with empty username and valid password");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		Assert.assertFalse(isProductsLabelDisplayed);
	}

	@Test
	@Parameters(value = { "username", "password" })
	public void validateIfUserIsAbleToLoginWithValidUsernameAndEmptyPassword(String username, String password) {
		ReportUtil.createTest("Login with valid username and empty password");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		ProductsPage productsPage = new ProductsPage(getDriver());
		boolean isProductsLabelDisplayed = productsPage.isProductsLabelDisplayed();
		Assert.assertFalse(isProductsLabelDisplayed);
	}

}
