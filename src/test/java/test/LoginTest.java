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

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    @Before
    public void beforeTest() {
        driver = new WebDriverHelper().generateWebDriver();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    public void login() {

        driver.get("https://anypoint.mulesoft.com/login/");

        CommonsPage commonsPage = new CommonsPage(driver, webDriverWait);
        commonsPage.acceptAllCookies();

        LoginPage loginPage = new LoginPage(driver,webDriverWait);
        loginPage.setUsername(ConfigurationValues.username);
        loginPage.setPassword(ConfigurationValues.password);
        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo("Anypoint Platform");
    }
}
