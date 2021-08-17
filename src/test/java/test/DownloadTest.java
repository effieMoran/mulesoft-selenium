package test;

import automation.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonsPage;
import pages.DownloadPage;

public class DownloadTest {

    private DownloadPage downloadPage;

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        downloadPage = new DownloadPage(driver, webDriverWait);
        CommonsPage commonsPage = new CommonsPage(driver, webDriverWait);
        downloadPage.navigate();
        commonsPage.acceptAllCookies();
    }

    @Test
    public void downloadAvailableTest() {
        downloadPage.selectOperatingSystem("Windows");
        downloadPage.fillFirstname("Eliana");
        downloadPage.fillLastname("Moran");
        downloadPage.fillCompany("Salesforce");
        downloadPage.fillJobTitle("Developer");
        downloadPage.fillEmail("people123@aol.com");
        downloadPage.fillPhoneNumber("1123324554");

        //TODO: Find out hot to click tha policy agreement
        //downloadPage.clickPolicyAgreement();

        downloadPage.clickDownloadButton();
    }
}
