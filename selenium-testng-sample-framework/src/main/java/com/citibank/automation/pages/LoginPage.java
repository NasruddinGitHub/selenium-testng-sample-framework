package com.citibank.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	private static final By USERNAME = By.id("user-name");
	private static final By PASSWORD = By.name("password");
	private static final By LOGIN = By.id("login-button");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void typeUsername(String username) {
		type(USERNAME, username, BasePage.HIGH_WAIT_TIME);
	}
	
	public void typePassword(String password) {
		type(PASSWORD, password, BasePage.HIGH_WAIT_TIME);
	}
	
	public void clickLogin() {
		click(LOGIN, BasePage.MEDIUM_WAIT_TIME);
	}
	
	public void login(String username, String password) {
		typeUsername(username);
		typePassword(password);
		clickLogin();
	}
}
