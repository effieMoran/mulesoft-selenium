package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;

@Epic("Coding Exercise")
@Feature("Search-bar")
public class SearchTest {

    private HomePage homePage;

    private static final String API = "api";

    private static final String TRIAL = "trial";

    @BeforeEach
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);

        homePage = new HomePage(driver, webDriverWait);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void searchApiTest() {

        homePage.navigate();
        homePage.acceptAllCookies();
        homePage.takeScreenShot();
        homePage.clickSearchButton();
        homePage.searchValue(API);

        assertThat(homePage.searchResults()).isGreaterThan(0);

        homePage.takeScreenShot();

        Set<String> links = homePage.findAllLInks();
        for (String link : links) {
            assertThat(homePage.getResponseStatusCode(link))
                    .isLessThan(400);
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void searchTrialTest() {

        homePage.navigate();
        homePage.acceptAllCookies();
        homePage.takeScreenShot();

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

    @AfterEach
    public void afterTest() {
        homePage.quit();
    }
}
