package ui.tests.base;

import com.sun.istack.logging.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.HomePage;
import ui.pages.LandingPage;
import ui.pages.LoginPage;

public class BaseTest {

    protected static WebDriver driver;
    private static final String URL = "https://www.trendyol.com/";
    protected static LandingPage landingPage = new LandingPage(driver);
    protected static LoginPage loginPage = new LoginPage(driver);
    protected static HomePage homePage = new HomePage(driver);

    static Logger log = Logger.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun=true)
    public void setUp() {
        log.info("Setup has been started for UI tests!");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        log.info("We are navigated to trendyol website successfully!");

        landingPage = new LandingPage(driver);
        landingPage.closePopUp();
        loginPage = landingPage.clickLogInBtn();
        driver.navigate().refresh();
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        driver.quit();

        log.info("Tests are run, browser has been closed!");
    }
}
