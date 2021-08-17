package test;

import automation.WebDriverHelper;
import config.ConfigurationValues;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonsPage;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    private LoginPage loginPage;

    private static final String ANYPOINT_PLATFORM = "Anypoint Platform";

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        loginPage = new LoginPage(driver, wait);
        CommonsPage commonsPage = new CommonsPage(driver, wait);
        loginPage.navigate();
        commonsPage.acceptAllCookies();
    }

    @Test
    public void login() {

        loginPage.setUsername(ConfigurationValues.username);
        loginPage.setPassword(ConfigurationValues.password);
        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo(ANYPOINT_PLATFORM);
    }
}
