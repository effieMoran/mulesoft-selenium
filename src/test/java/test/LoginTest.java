package test;

import automation.WebDriverHelper;
import config.ConfigurationValues;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonsPage;
import pages.LoginPage;

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
        commonsPage.aceptAllCokies();

        LoginPage loginPage = new LoginPage(driver,webDriverWait);
        loginPage.setUsername(ConfigurationValues.username);
        loginPage.setPassword();
        loginPage.clickSubmitButton();

        Assert.assertEquals("Anypoint Platform", loginPage.getTitleText());
    }
}
