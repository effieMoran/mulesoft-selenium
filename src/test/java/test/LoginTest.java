package test;

import config.ServiceConfig;
import config.YamlConfig;
import util.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    private LoginPage loginPage;

    private ServiceConfig properties;

    private static final String ANYPOINT_PLATFORM = "Anypoint Platform";

    private static final String AUTOMATION = "automation";

    @Before
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
    public void login() {

        loginPage.setUsername(properties.getUsername());
        loginPage.setPassword(properties.getPassword());
        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo(ANYPOINT_PLATFORM);
    }
}
