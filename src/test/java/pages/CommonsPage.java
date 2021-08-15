package pages;

import org.openqa.selenium.By;
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

    public void aceptAllCokies() {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonId));
        driver.findElement(buttonId).click();
    }
}
