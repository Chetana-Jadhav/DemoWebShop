package PageObjects;

import Utilities.TestContext;
import com.google.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;

@Log4j2
public class HomePageObjects {
    @Inject
    TestContext testContext;

    private By registerLink = By.xpath("//a[contains(text(),'Register')]");
    private By searchbar = By.xpath("//input[@id='small-searchterms']");
    private By searchEnter = By.xpath("//input[@class='button-1 search-box-button']");
    private By productNameLInk = By.xpath("//a[contains(text(),'Digital SLR Camera 12.2 Mpixel')]");


    public void ClickOnRegisterLink() {
        testContext.getDriver().findElement(registerLink).click();
        log.debug("Register link clisked");

    }

    public void EnterValueInSearchBar() {
        testContext.getDriver().findElement(searchbar).sendKeys("camera");
        log.debug("product name entered in search bar");
        testContext.getDriver().findElement(searchEnter).click();
        log.debug("search button clicked");
    }

    public void ClickOnProductName() {
        JavascriptExecutor js = (JavascriptExecutor) testContext.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", testContext.getDriver().findElement(productNameLInk));
        testContext.getDriver().findElement(productNameLInk).click();
        log.debug("Product name link clicked");
    }


}
