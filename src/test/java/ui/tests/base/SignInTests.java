package ui.tests.base;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SignInTests extends BaseTest{

    @Test(groups= "SignInTest")
    public void testSignInFieldFunctionality() {
        log.info("SignIn tests are started!");
        loginPage.clickSignInField();
        assertTrue(loginPage.getPasswordInfoText().contains("Şifreniz "));
    }

    @Test(groups= "SignInTest")
    public void testShortPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("1a2b");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz 7 ile 64 karakter arasında olmalıdır."));
    }

    @Test(groups= "SignInTest")
    public void testLongPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d1a2b3c4d");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz 7 ile 64 karakter arasında olmalıdır."));
    }

    @Test(groups= "SignInTest")
    public void testOnlyNumberPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("11223344");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz en az 1 harf içermelidir."));
    }

    @Test(groups= "SignInTest")
    public void testOnlyLetterPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("aabbccdd");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz en az 1 rakam içermelidir."));
    }

    @Test(groups= "SignInTest")
    public void testOnlyCharacterPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("********");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz en az 1 harf içermelidir."));
    }

    @Test(groups= "SignInTest")
    public void testOnlySpaceBarPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("         ");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz boşluk içeremez."));
    }

    @Test(groups= "SignInTest")
    public void testAlphaNumericWithSpaceBarPasswordOnRegister() {
        loginPage.registerWithVariousPasswords("1a2b3c4d ");
        assertTrue(loginPage.getRegisterErrorMessage().contains("Şifreniz boşluk içeremez."));
    }
}
