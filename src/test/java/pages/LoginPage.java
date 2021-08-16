package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private By usernameLocator = By.cssSelector("input[data-test-id=SignIn-Username]");

    private By passwordLocator = By.cssSelector("input[data-test-id=SignIn-Password]");

    private By submitButtonLocator = By.cssSelector ("button[data-test-id=SignIn-Submit]");

    private By titleLocator = By.cssSelector("div[data-test-id=navbar-page-name]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public String getTitleText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
        return driver.findElement(titleLocator).getText();
    }

}
