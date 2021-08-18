package test;

import automation.WebDriverHelper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DownloadPage;

public class DownloadTest {

    private DownloadPage downloadPage;

    @Before
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 100);

        downloadPage = new DownloadPage(driver,webDriverWait);
        downloadPage.navigate();
        downloadPage.acceptAllCookies();
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
        downloadPage.clickPolicyAgreement();
        downloadPage.clickDownloadButton();
    }
}
