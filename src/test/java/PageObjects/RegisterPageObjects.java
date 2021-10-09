package PageObjects;

import Utilities.BaseTest;
import Utilities.TestContext;
import com.google.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Log4j2
public class RegisterPageObjects extends BaseTest {
    @Inject
    TestContext testContext;

    private By gender = By.xpath("//input[@id='gender-female']");
    private By FirstName = By.xpath("//input[@id='FirstName']");
    private By LastName = By.xpath("//input[@id='LastName']");
    private By Email = By.xpath("//input[@id='Email']");
    private By password = By.xpath("//input[@id='Password']");
    private By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    private By registerButton = By.xpath("//input[@id='register-button']");
    private By registerSuccessMsg = By.xpath("//div[contains(text(),'Your registration completed')]");
    private By login_link = By.xpath("//a[contains(text(),'Log in')]");
    private By emailId = By.xpath("//input[@id='Email']");
    private By Password = By.xpath("//input[@id='Password']");
    private By loginButton = By.xpath("//input[@class='button-1 login-button']");


    public void RegisterFormFilling() {
        testContext.getDriver().findElement(gender).click();
        log.debug("Gender selected");
        testContext.getDriver().findElement(FirstName).sendKeys(firstName);
        log.debug("First Name entered");
        testContext.getDriver().findElement(LastName).sendKeys(lastName);
        log.debug("last Name entered");
        testContext.getDriver().findElement(Email).sendKeys(email);
        log.debug("Email entered");
        testContext.getDriver().findElement(password).sendKeys(pswd);
        log.debug("Password entered");
        testContext.getDriver().findElement(confirmPassword).sendKeys(pswdconfirm);
        log.debug("Password Confirmed");
        testContext.getDriver().findElement(registerButton).click();
        log.debug("Register button clicked");
        WebElement Message = testContext.getDriver().findElement(registerSuccessMsg);
        boolean successMsg = Message.isDisplayed();
        Assert.assertEquals(successMsg, true);
        testContext.getScenario().log("Message after registration : " + Message.getText());
        log.debug("Message: " + Message.getText() + " validated");
    }

    public void clickOnLoginLink(){
        testContext.getDriver().findElement(login_link).click();
        Assert.assertEquals(testContext.getDriver().getTitle(),"Demo Web Shop. Login");
        log.debug("login link clicked");
    }
    public void enter_email_and_password_as(String string, String string2) {
        testContext.getDriver().findElement(emailId).sendKeys(string);
        log.debug("Email Id entered as "+string);
        testContext.getDriver().findElement(Password).sendKeys(string2);
        log.debug("Password entered as "+string2);
    }

    public void clickOnLoginButton(){
        testContext.getDriver().findElement(loginButton).click();
        log.debug("login button clicked");
    }
    public void validatePageTitle(){
        Assert.assertEquals(testContext.getDriver().getTitle(),"Demo Web Shop");
        log.debug("Page title validated");
    }
    public void validate_Page_Title(){
        Assert.assertNotEquals(testContext.getDriver().getTitle(),"Demo Web Shop");
        log.debug("Page title validated");
    }
}
