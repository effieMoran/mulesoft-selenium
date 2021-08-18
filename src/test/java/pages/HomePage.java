package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage{

    private By searchIconLocator = By.id("header-nav-search-form");

    private By searchInputLocator = By.cssSelector ("input[placeholder=Search]");

    private By searchResultsTableLocator = By.id("search-results");

    private By searchResultLocator = By.cssSelector("div.sresult");

    private By searchResultsPaginatedLocator = By.tagName("div");

    private By footerCopyrightLocator = By.cssSelector("p[class=footer-copyright]");

    private By linkLocator = By.tagName("a");

    private static Logger logger = LoggerFactory.getLogger(HomePage.class);

    private static final String HREF = "href";

    private static final int CONNECTION_TIMEOUT = 10000;

    private final static String HOME_PAGE_URL = "https://www.mulesoft.com/";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
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

    public String getCopyright() {
        return driver.findElement(footerCopyrightLocator).getText();
    }


    public Set<String> findAllLInks() {
        WebElement searchTable = driver.findElement(searchResultsTableLocator);
        List<WebElement> links = searchTable.findElements(linkLocator);
        Set<String> allLinks = new HashSet<>();
        for(WebElement link: links) {
            String url = link.getAttribute(HREF);
            if (null != url && !url.isEmpty()) {
                allLinks.add(url);
            }
        }
        return allLinks;
    }

    public int getResponseStatusCode(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(CONNECTION_TIMEOUT);
            httpURLConnect.connect();
            return httpURLConnect.getResponseCode();
        } catch (IOException e) {
            logger.debug("An unexpected error happened during the request to : " + linkUrl);
            return 0;
        }
    }
}
