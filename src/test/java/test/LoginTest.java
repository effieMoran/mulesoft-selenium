package test;

import automation.WebDriverHelper;
import config.ConfigurationValues;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    private LoginPage loginPage;

    private static final String ANYPOINT_PLATFORM = "Anypoint Platform";

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        loginPage = new LoginPage(driver,wait);

        loginPage.navigate();
        loginPage.acceptAllCookies();
    }

    @Test
    public void login() {

        loginPage.setUsername(ConfigurationValues.username);
        loginPage.setPassword(ConfigurationValues.password);
        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo(ANYPOINT_PLATFORM);
    }
}
