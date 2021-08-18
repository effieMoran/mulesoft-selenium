package test;

import automation.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonsPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class MainFeaturesTest {

    private HomePage homePage;

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        homePage = new HomePage(driver, webDriverWait);
        CommonsPage commonsPage = new CommonsPage(driver, webDriverWait);
        homePage.navigate();
        commonsPage.acceptAllCookies();
    }

    @Test
    public void socialLinksTest() {

    }

    @Test
    public void headerTest() {

    }

    @Test
    public void footerTest() {


        assertThat(homePage.getCopyright())
                .isNotEmpty()
                .contains("©2021")
                .contains("MuleSoft LLC, a Salesforce company");
    }
}
