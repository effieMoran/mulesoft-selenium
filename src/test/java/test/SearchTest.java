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

    private HomePage homePage;

    private static final String API = "api";

    private static final String TRIAL = "trial";

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
