package test;

import config.ServiceConfig;
import config.YamlConfig;
import io.qameta.allure.Description;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import util.WebDriverHelper;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("make a report")
public class LoginTest {

    private LoginPage loginPage;

    private ServiceConfig properties;

    private static final String ANYPOINT_PLATFORM = "Anypoint Platform";

    private static final String AUTOMATION = "automation";

    @BeforeEach
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        loginPage = new LoginPage(driver,wait);
        loginPage.navigate();
        loginPage.acceptAllCookies();

        Map<String, ServiceConfig> s = YamlConfig.init();
        properties = s.get(AUTOMATION);
    }

    @Test
    @Description("Try to login with a previously registered user.")
    public void login() {

        loginPage.setUsername(properties.getUsername());
        loginPage.setPassword(properties.getPassword());
        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo(ANYPOINT_PLATFORM);
    }

    @AfterEach
    public void quit() {
        loginPage.quit();
    }
}
