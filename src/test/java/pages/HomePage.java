package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait wait;

    private By searchIconLocator = By.id("header-nav-search-form");

    private By searchInputLocator = By.cssSelector ("input[placeholder=Search]");

    private By searchTitle = By.id("component-banner-7416");

    private By searchResultsLocator = By.id("search-results");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.get("https://www.mulesoft.com/");
    }

    public void clickSearchButton() {
        driver.findElement(searchIconLocator).click();
    }

    public void searchValue(String searchInput) {
        WebElement searchBar = driver.findElement(searchInputLocator);
        searchBar.sendKeys(searchInput);
        searchBar.sendKeys(Keys.ENTER);
    }

    public int searchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResultsLocator));
        WebElement searchResults = driver.findElement(searchResultsLocator);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.sresult")));
        return searchResults.findElements(By.tagName("div")).size();
    }
}
