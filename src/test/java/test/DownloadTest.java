package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DownloadPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Coding Exercise")
@Feature("Download Files")
public class DownloadTest {

    private DownloadPage downloadPage;

    @BeforeEach
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
        downloadPage = new DownloadPage(driver,webDriverWait);
    }

    @Test
    public void downloadAvailableTest() {

        downloadPage.navigate();
        downloadPage.acceptAllCookies();
        downloadPage.takeScreenShot();

        downloadPage.selectOperatingSystem("Windows");
        downloadPage.fillFirstname("Eliana");
        downloadPage.fillLastname("Moran");
        downloadPage.fillCompany("Salesforce");
        downloadPage.fillJobTitle("Developer");
        downloadPage.fillEmail("people123@aol.com");
        downloadPage.fillPhoneNumber("1123324554");
        downloadPage.clickPolicyAgreement();
        downloadPage.takeScreenShot();

        downloadPage.clickDownloadButton();

        assertThat(downloadPage.getCongratulationsText())
                .contains("Thank you for downloading Anypoint Studio and Mule");
    }

//    @AfterEach
//    public void afterTest() {
//        downloadPage.quit();
//    }
}
