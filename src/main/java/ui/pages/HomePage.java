package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By myAccountText = By.xpath("//div[@class='link account-user']/p");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isMyAccountTextDisplayed () {
        return isDisplayed(myAccountText);
    }
}
