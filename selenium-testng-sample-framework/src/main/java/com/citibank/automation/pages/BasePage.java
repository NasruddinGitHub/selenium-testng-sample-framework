package com.citibank.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	protected static final int MEDIUM_WAIT_TIME = 5;
	protected static final int HIGH_WAIT_TIME = 15;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilElementIsVisible(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitAndFindElement(By locator, int waitTimeInSeconds) {
		waitUntilElementIsVisible(locator, waitTimeInSeconds);
		return driver.findElement(locator);
	}

	public List<WebElement> waitAndFindElements(By locator, int waitTimeInSeconds) {
		waitUntilElementIsVisible(locator, waitTimeInSeconds);
		return driver.findElements(locator);
	}

	public void click(By locator, int waitTimeInSeconds) {
		waitAndFindElement(locator, waitTimeInSeconds).click();
	}

	public void type(By locator, CharSequence input, int waitTimeInSeconds) {
		waitAndFindElement(locator, waitTimeInSeconds).sendKeys(input);
	}

	public boolean isElementDisplayed(By locator, int waitTimeInSeconds) {
		try {
			waitUntilElementIsVisible(locator, waitTimeInSeconds);
			return true;
		}catch(TimeoutException e) {
			return false;
		}
	}
	

}
