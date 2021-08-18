package test;

import automation.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.HomePage;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private HomePage homePage;

    private BasePage basePage;

    private static final String API = "api";

    private static final String TRIAL = "trial";

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);

        homePage = new HomePage(driver, webDriverWait);
        basePage = new BasePage(driver, webDriverWait);
        homePage.navigate();
        basePage.acceptAllCookies();
    }

    @Test
    public void searchApiTest() {
        homePage.clickSearchButton();
        homePage.searchValue(API);

        basePage.takeScreenShot();

        assertThat(homePage.searchResults()).isGreaterThan(0);

        basePage.takeScreenShot();

        Set<String> links = homePage.findAllLInks();
        for (String link : links) {
            assertThat(homePage.verifyLink(link))
                    .isLessThan(400);
        }
    }

    @Test
    public void searchTrialTest() {
        homePage.clickSearchButton();
        homePage.searchValue(TRIAL);

        basePage.takeScreenShot();

        assertThat(homePage.searchResults()).isGreaterThan(0);

        basePage.takeScreenShot();

        Set<String> links = homePage.findAllLInks();
        for (String link : links) {
            assertThat(homePage.verifyLink(link))
                    .isLessThan(400);
        }
    }
}
