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

    @Before
    public void beforeTest() {
        driver = new WebDriverHelper().generateWebDriver();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    public void searchApiTest() {
        driver.get("https://www.mulesoft.com/");

        CommonsPage commonsPage = new CommonsPage(driver, webDriverWait);
        commonsPage.acceptAllCookies();

        HomePage homePage = new HomePage(driver, webDriverWait);
        homePage.clickSearchButton();

        homePage.searchValue("api");

        assertThat(homePage.searchResults()).isGreaterThan(0);
    }
}
