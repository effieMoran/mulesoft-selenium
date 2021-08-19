package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import util.WebDriverHelper;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Coding Exercise")
@Feature("Header and Footer")
public class MainFeaturesTest {

    private HomePage homePage;

    @BeforeEach
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver,webDriverWait);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void headerTest() {

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void footerTest() {

        homePage.navigate();
        homePage.acceptAllCookies();
        homePage.takeScreenShot();

        ArrayList<String> expectedSocialMediaLinks = new ArrayList<>();
        expectedSocialMediaLinks.add("https://twitter.com/MuleSoft");
        expectedSocialMediaLinks.add("https://www.linkedin.com/company/mulesoft");
        expectedSocialMediaLinks.add("https://www.facebook.com/mulesoft");
        expectedSocialMediaLinks.add("https://www.instagram.com/mulesoft");
        expectedSocialMediaLinks.add("https://videos.mulesoft.com/");

        List<String> socialMediaLinks = homePage.getSocialMediaLinks();

        assertThat(socialMediaLinks)
                .containsAll(expectedSocialMediaLinks);

        assertThat(homePage.getCopyright())
                .isNotEmpty()
                .contains("2021")
                .contains("MuleSoft LLC, a Salesforce company");

        homePage.takeScreenShot();
    }

    @AfterEach
    public void afterTest() {
        homePage.quit();
    }
}
