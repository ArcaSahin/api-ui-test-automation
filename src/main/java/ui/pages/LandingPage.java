package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage{

    private By logInButton = By.xpath("//div/p[contains(text(), 'Giriş Yap')]");

    private By closePopUp = By.id("Combined-Shape");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogInBtn () {
        click(logInButton);
        return new LoginPage(driver);
    }

    public LandingPage closePopUp () {
        WebElement element = driver.findElement(closePopUp);
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }
        return this;
    }
}
