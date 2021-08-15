package pages;

import automation.WebDriverHelper;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    @Before
    public void beforeTest() {
        driver = new WebDriverHelper().generateWebDriver();
    }


}
