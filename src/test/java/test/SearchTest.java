package test;

import org.junit.After;
import util.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private HomePage homePage;

    private static final String API = "api";

    private static final String TRIAL = "trial";

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);

        homePage = new HomePage(driver, webDriverWait);
        homePage.navigate();
        homePage.acceptAllCookies();
    }

    @Test
    public void searchApiTest() {
        homePage.clickSearchButton();
        homePage.searchValue(API);

        homePage.takeScreenShot();

        assertThat(homePage.searchResults()).isGreaterThan(0);

        homePage.takeScreenShot();

        Set<String> links = homePage.findAllLInks();
        for (String link : links) {
            assertThat(homePage.getResponseStatusCode(link))
                    .isLessThan(400);
        }
    }

    @Test
    public void searchTrialTest() {
        homePage.clickSearchButton();
        homePage.searchValue(TRIAL);

        homePage.takeScreenShot();

        assertThat(homePage.searchResults()).isGreaterThan(0);

        homePage.takeScreenShot();

        Set<String> links = homePage.findAllLInks();
        for (String link : links) {
            assertThat(homePage.getResponseStatusCode(link))
                    .isLessThan(400);
        }
    }

    @After
    public void afterTest() {
        homePage.quit();
    }
}
