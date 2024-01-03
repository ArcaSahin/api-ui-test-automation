package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By usernameField = By.id("login-email");
    private By passwordField = By.id("login-password-input");
    private By loginButton = By.xpath("//button[@type='submit']/span");
    private By errorMessage = By.xpath("//div/span[@class='message']");
    private By forgotPasswordField = By.xpath("//span[contains(text(), 'Şifremi Unuttum')]");
    private By refreshPasswordField = By.xpath("//button[@type='submit']");
    private By eyeOpenField = By.xpath("//i[@class='i-eye-open']");
    private By withoutSignInField = By.xpath("//span[contains(text(), 'tıklayınız')]");
    private By popularQuestionsText = By.xpath("//span[contains(text(), 'Popüler Sorular')]");
    private By signInField = By.xpath("//span[contains(text(), 'Üye Ol')]");
    private By passwordInfoTextField = By.xpath("//span[@class='password-info-text']");
    private By registerPasswordField = By.xpath("//input[@name='register-password']");
    private By submitField = By.xpath("//button[@type='submit']");
    private By registerErrorMessage = By.xpath("//span[@class='message']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername (String username) {
        type(username, usernameField);
    }

    public void setPassword (String password) {
        type(password, passwordField);
    }

    public void registerPassword (String password) {
        type(password, registerPasswordField);
    }

    public HomePage loginWith (String username, String password) {
        setUsername(username);
        setPassword(password);
        click(loginButton);
        return new HomePage(driver);
    }

    public String getErrorMessage () {
        return find(errorMessage).getText();
    }

    public LoginPage clickForgotPassword () {
        click(forgotPasswordField);
        return new LoginPage(driver);
    }

    public Boolean isRefreshPasswordDisplayed () {
        return isDisplayed(refreshPasswordField);
    }

    public LoginPage clickWithoutSignInField () {
        click(withoutSignInField);
        return new LoginPage(driver);
    }

    public Boolean isPopularQuestionsTextIsDisplayed () {
        return isDisplayed(popularQuestionsText);
    }

    public LoginPage clickSignInField () {
        click(signInField);
        return new LoginPage(driver);
    }

    public String getPasswordInfoText () {
        return find(passwordInfoTextField).getText();
    }

    public LoginPage registerWithVariousPasswords (String password) {
        click(signInField);
        registerPassword(password);
        click(submitField);
        return new LoginPage(driver);
    }
    public String getRegisterErrorMessage () {
        return find(registerErrorMessage).getText();
    }
}
