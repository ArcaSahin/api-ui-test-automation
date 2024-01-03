package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find (By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    protected void type (String text, By locator) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click (By locator) {
        find(locator).click();
    }

    protected Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        }
        catch (NoSuchElementException exc) {
            return false;
        }
    }
}
