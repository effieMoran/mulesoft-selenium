package test;

import automation.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonsPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    private HomePage homePage;

    private CommonsPage commonsPage;

    private static final String API = "api";

    private static final String TRIAL = "trial";

    @Before
    public void beforeTest() {
        driver = new WebDriverHelper().generateWebDriver();
        webDriverWait = new WebDriverWait(driver, 10);

        homePage = new HomePage(driver, webDriverWait);
        commonsPage = new CommonsPage(driver, webDriverWait);
        homePage.navigate();
        commonsPage.acceptAllCookies();
    }

    @Test
    public void searchApiTest() {
        homePage.clickSearchButton();
        homePage.searchValue(API);
        assertThat(homePage.searchResults()).isGreaterThan(0);
    }

    @Test
    public void searchTrialTest() {
        homePage.clickSearchButton();
        homePage.searchValue(TRIAL);
        assertThat(homePage.searchResults()).isGreaterThan(0);
    }
}
