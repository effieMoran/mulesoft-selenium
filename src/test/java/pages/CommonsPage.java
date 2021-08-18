package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonsPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private By buttonId = By.id("onetrust-accept-btn-handler");

    public CommonsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void acceptAllCookies() {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonId));
        driver.findElement(buttonId).click();
    }

    @Attachment
    @Step("Make screen shot of results page")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
