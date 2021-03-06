package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage extends BasePage {

    private final static String DOWNLOAD_URL = "https://www.mulesoft.com/lp/dl/studio";

    private By operatingSystemLocator = By.id("operatingSystem");

    private By firstNameLocator = By.id("FirstName");

    private By lastnameLocator = By.id("LastName");

    private By emailLocator = By.id("Email");

    private By companyLocator = By.id("Company");

    private By jobTitleLocator = By.id("Title");

    private By phoneNumberLocator = By.id("Phone");

    private By downloadButtonLocator = By.cssSelector("button[type=submit]");

    private By congratulationsLocator = By.cssSelector(".block-mule-foundation-content");

    private static final String POLICY_AGREEMENT_SCRIPT = "document.querySelector('#LblBeta_License_Agreement__c').click()";

    private static final String DOWNLOAD = "download";

    public DownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void navigate() {
        driver.get(DOWNLOAD_URL);
    }

    public void selectOperatingSystem(String operatingSystemName) {
        WebElement operatingSystem = driver.findElement(operatingSystemLocator);
        operatingSystem.sendKeys(operatingSystemName);
    }

    public void fillFirstname(String firstname) {
        WebElement firstnameInput = driver.findElement(firstNameLocator);
        firstnameInput.sendKeys(firstname);
    }

    public void fillLastname(String lastname) {
        WebElement lastnameInput = driver.findElement(lastnameLocator);
        lastnameInput.sendKeys(lastname);
    }

    public void fillEmail(String email) {
        WebElement emailInput = driver.findElement(emailLocator);
        emailInput.sendKeys(email);
    }

    public void fillJobTitle(String jobTitle) {
        WebElement jobTitleInput = driver.findElement(jobTitleLocator);
        jobTitleInput.sendKeys(jobTitle);
    }

    public void fillCompany(String company) {
        WebElement companyInput = driver.findElement(companyLocator);
        companyInput.sendKeys(company);
    }

    public void fillPhoneNumber(String phoneNumber) {
        WebElement phoneNumberInput = driver.findElement(phoneNumberLocator);
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void clickPolicyAgreement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(POLICY_AGREEMENT_SCRIPT);
    }

    public void clickDownloadButton() {
        driver.findElement(downloadButtonLocator).click();
    }

    public String getCongratulationsText() {
        wait.until(ExpectedConditions.urlContains(DOWNLOAD));
        return driver.findElement(congratulationsLocator).getText();
    }
}
