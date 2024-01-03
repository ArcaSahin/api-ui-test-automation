package ui.tests.base;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends BaseTest {

    @Test(groups= "LoginTest")
    public void testValidUserCanLogin() {
        log.info("Login tests are started!");
        homePage = loginPage.loginWith(
                "debimung@jgroupdesigns.com", "1a2b3c4d");
        assertTrue(homePage.isMyAccountTextDisplayed());
    }

    @Test(groups= "LoginTest")
    public void testValidUsernameAndInvalidPasswordCanLogin() {
        homePage = loginPage.loginWith(
                "debimung@jgroupdesigns.com", "1A2B3C4D");
        assertTrue(loginPage.getErrorMessage().contains("E-posta adresiniz ve/veya şifreniz hatalı."));
    }

    @Test(groups= "LoginTest")
    public void testInvalidUsernameAndValidPasswordCanLogin() {
        homePage = loginPage.loginWith(
                "arca@jgroupdesigns.com", "1a2b3c4d");
        assertTrue(loginPage.getErrorMessage().contains("E-posta adresiniz ve/veya şifreniz hatalı."));
    }

    @Test(groups= "LoginTest")
    public void testNullUsernameAndValidPasswordCanLogin() {
        homePage = loginPage.loginWith(
                "", "1a2b3c4d");
        assertTrue(loginPage.getErrorMessage().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test(groups= "LoginTest")
    public void testValidUsernameAndNullPasswordCanLogin() {
        homePage = loginPage.loginWith(
                "debimung@jgroupdesigns.com", "");
        assertTrue(loginPage.getErrorMessage().contains("Lütfen şifrenizi giriniz."));
    }

    @Test(groups= "LoginTest")
    public void testNullUsernameAndNullPasswordCanLogin() {
        homePage = loginPage.loginWith(
                "", "");
        assertTrue(loginPage.getErrorMessage().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test(groups= "LoginTest")
    public void testForgotPasswordFieldFunctionality() {
        loginPage.clickForgotPassword();
        assertTrue(loginPage.isRefreshPasswordDisplayed());
    }

    @Test(groups= "LoginTest")
    public void testWithoutSignInLinkTextFunctionality() {
        loginPage.clickWithoutSignInField();
        assertTrue(loginPage.isPopularQuestionsTextIsDisplayed());
    }

}
