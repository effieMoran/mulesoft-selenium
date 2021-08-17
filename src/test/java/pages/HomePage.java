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

    private By searchResultsTableLocator = By.id("search-results");

    private By searchResultLocator = By.cssSelector("div.sresult");

    private By searchResultsPaginatedLocator = By.tagName("div");

    private final static String HOME_PAGE_URL = "https://www.mulesoft.com/";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.get(HOME_PAGE_URL);
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
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResultsTableLocator));
        WebElement searchResults = driver.findElement(searchResultsTableLocator);

        wait.until(ExpectedConditions.presenceOfElementLocated(searchResultLocator));
        return searchResults.findElements(searchResultsPaginatedLocator).size();
    }
}
