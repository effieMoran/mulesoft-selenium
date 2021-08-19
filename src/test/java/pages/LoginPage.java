package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By usernameLocator = By.cssSelector("input[data-test-id=SignIn-Username]");

    private By passwordLocator = By.cssSelector("input[data-test-id=SignIn-Password]");

    private By submitButtonLocator = By.cssSelector ("button[data-test-id=SignIn-Submit]");

    private By titleLocator = By.cssSelector("div[data-test-id=navbar-page-name]");

    private static final String ANYPOINT_LOGIN_URL = "https://anypoint.mulesoft.com/login/";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    @Step("Navigate to Anypoint Platform Sign in page")
    public void navigate() {
        driver.get(ANYPOINT_LOGIN_URL);
    }

    @Step("Enter username {0}")
    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    @Step("Enter password {0}")
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
