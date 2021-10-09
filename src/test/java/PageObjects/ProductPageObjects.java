package PageObjects;

import Utilities.TestContext;
import com.google.inject.Inject;
import io.cucumber.java.sl.In;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

@Log4j2
public class ProductPageObjects {
    @Inject
    TestContext testContext;

    private By quantityBox = By.xpath("//input[@id='addtocart_18_EnteredQuantity']");
    private By AddToCartButton = By.xpath("//input[@id='add-to-cart-button-18']");
    private By addedToCartMessage = By.xpath("//body/div[@id='bar-notification']/p[1]");
    private By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    private By checkbox = By.xpath("//input[@id='termsofservice']");
    private By checkout = By.xpath("//button[@id='checkout']");
    private By First_Name = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    private By Last_Name = By.xpath("//input[@id='BillingNewAddress_LastName']");
    private By Email_add = By.xpath("//input[@id='BillingNewAddress_Email']");
    private By country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private By city = By.xpath("//input[@id='BillingNewAddress_City']");
    private By Address = By.xpath("//input[@id='BillingNewAddress_Address1']");
    private By Zipcode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private By phone = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    private By ContinueButton = By.xpath("//input[@class='button-1 new-address-next-step-button' and @onclick = 'Billing.save()']");
    private By billingAdd = By.xpath("//select[@id='shipping-address-select']");
    private By Continue_button = By.xpath("//input[@class='button-1 new-address-next-step-button' and @onclick = 'Shipping.save()']");
    private By shipping_method = By.xpath("//input[@id='shippingoption_1']");
    private By paymentMethod = By.xpath("//input[@id='paymentmethod_3']");
    private By ContinueButton1 = By.xpath("//input[@class='button-1 shipping-method-next-step-button' and @onclick = 'ShippingMethod.save()']");
    private By ContinueButton2 = By.xpath("//input[@class='button-1 payment-method-next-step-button' and @onclick = 'PaymentMethod.save()']");
    private By purchaseOrder = By.xpath("//input[@id='PurchaseOrderNumber']");
    private By ContinueButton3 = By.xpath("//input[@class='button-1 payment-info-next-step-button' and @onclick = 'PaymentInfo.save()']");
    private By ConfirmOrder = By.xpath("//input[@class='button-1 confirm-order-next-step-button' and @onclick = 'ConfirmOrder.save()']");
    private By orderSuccessMsg = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
    private By orderNumber = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]");


    public void changeQuantity(String string) {
        testContext.getDriver().findElement(quantityBox).sendKeys(Keys.BACK_SPACE);
        testContext.getDriver().findElement(quantityBox).sendKeys(string);
        log.debug("Quantity entered as " + string);

    }

    public void Click_on_add_to_cart() {
        testContext.getDriver().findElement(AddToCartButton).click();
        log.debug("Add to cart button clicked");
        Assert.assertEquals(testContext.getDriver().findElement(addedToCartMessage).isDisplayed(), true);
        log.debug("Add to cart message " + testContext.getDriver().findElement(addedToCartMessage).getText() + " validated ");
        testContext.getScenario().log("Message: " + testContext.getDriver().findElement(addedToCartMessage).getText());
    }

    public void ClickOnShoppingCartLink() {
        testContext.getDriver().findElement(shoppingCartLink).click();
        log.debug("shopping cart link clicked");
        Assert.assertEquals(testContext.getDriver().getTitle(), "Demo Web Shop. Shopping Cart");
        log.debug("cart page title validated");
    }

    public void ClickOnTermsAndConditionsCheckbox() {
        testContext.getDriver().findElement(checkbox).click();
        log.debug("Terms and conditions checked");
    }

    public void click_on_checkout_button() {
        testContext.getDriver().findElement(checkout).click();
        log.debug("checkout button clicked");
    }

    public void enter_firstName(String args) {
        WebElement firstNameField = testContext.getDriver().findElement(First_Name);
        firstNameField.clear();
        firstNameField.sendKeys(args);
        log.debug("First name entered");
    }

    public void enter_LastName(String args) {
        WebElement lastNameField = testContext.getDriver().findElement(Last_Name);
        lastNameField.clear();
        lastNameField.sendKeys(args);
        log.debug("Last name entered");
    }

    public void select_country(String args) {
        Select Country = new Select(testContext.getDriver().findElement(country));
        Country.selectByVisibleText(args);
        log.debug("country selected as " + args);
    }

    public void enter_city(String args) {
        testContext.getDriver().findElement(city).sendKeys(args);
        log.debug("City entered as " + args);
    }

    public void enter_Address(String args) {
        testContext.getDriver().findElement(Address).sendKeys(args);
        log.debug("Address entered as " + args);
    }

    public void enter_zipcode(String args) {
        testContext.getDriver().findElement(Zipcode).sendKeys(args);
        log.debug("zipcode entered as " + args);
    }

    public void enter_phone(String args) {
        testContext.getDriver().findElement(phone).sendKeys(args);
        log.debug("Phone entered as " + args);
    }

    public void clickOnContinue() {
        testContext.getDriver().findElement(ContinueButton).click();
        log.debug("Continue button clicked");
    }

    public void select_shippingAddress_SameAs_BillingAddress() {
        Select shippingAdd = new Select(testContext.getDriver().findElement(billingAdd));
        shippingAdd.getFirstSelectedOption();
        log.debug("Shipping address selected same as billing address");
    }

    public void click_on_continue() {
        testContext.getDriver().findElement(Continue_button).click();
        log.debug("Continue button clicked");
    }

    public void select_shipping_method() {
        testContext.getDriver().findElement(shipping_method).click();
        log.debug("Shipping Method selected");
        testContext.getDriver().findElement(ContinueButton1).click();
        log.debug("Continue button clicked");
    }

    public void select_payment_method() {
        testContext.getDriver().findElement(paymentMethod).click();
        log.debug("Payment Method selected");
        testContext.getDriver().findElement(ContinueButton2).click();
        log.debug("Continue button clicked");
    }

    public void enter_purchaseOrder_No(String string) {
        testContext.getDriver().findElement(purchaseOrder).sendKeys(string);
        log.debug("Purchase order number entered as " + string);
        testContext.getDriver().findElement(ContinueButton3).click();
        log.debug("Continue button clicked");
    }

    public void click_on_confirm() {
        testContext.getDriver().findElement(ConfirmOrder).click();
        log.debug("Confirm button clicked");
    }

    public void order_is_successfully_placed_and_thank_you_message_is_displayed() {
        Assert.assertEquals(testContext.getDriver().findElement(orderSuccessMsg).isDisplayed(), true);
        testContext.getScenario().log("Message " + testContext.getDriver().findElement(orderSuccessMsg).getText());
        testContext.getScenario().log(testContext.getDriver().findElement(orderNumber).getText());
        log.debug("Message : " + testContext.getDriver().findElement(orderNumber).getText() + " validated");
    }

    public void order_number_displayed() {
        Assert.assertEquals(testContext.getDriver().findElement(orderNumber).isDisplayed(), true);
        testContext.getScenario().log(testContext.getDriver().findElement(orderNumber).getText());
        log.debug("Message: " + testContext.getDriver().findElement(orderNumber).getText() + " validated");
    }
}
