package Stepdefs;

import PageObjects.HomePageObjects;
import PageObjects.ProductPageObjects;
import PageObjects.RegisterPageObjects;
import Utilities.BaseTest;
import Utilities.TestContext;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

import java.util.Map;

@Log4j2
public class Stepdefinition extends BaseTest {
    @Inject
    TestContext testContext;

    @Inject
    HomePageObjects homePageObjects;

    @Inject
    RegisterPageObjects registerPageObjects;

    @Inject
    ProductPageObjects productPageObjects;

    @Given("I have on the landing page of the application")
    public void i_have_on_the_landing_page_of_the_application() {
        testContext.getDriver().get(url);
    }

    @Given("I register as a new user")
    public void i_register_as_a_new_user() {
        homePageObjects.ClickOnRegisterLink();
        registerPageObjects.RegisterFormFilling();

    }

    @Given("I search for a product")
    public void i_search_for_a_product() {
        homePageObjects.EnterValueInSearchBar();
        homePageObjects.ClickOnProductName();
    }

    @Given("I add the product to the basket with quantity as {string}")
    public void i_add_the_product_to_the_basket_with_quantity_as(String string) {
        productPageObjects.changeQuantity(string);
        productPageObjects.Click_on_add_to_cart();

    }

    @Given("I navigate to the cart")
    public void i_navigate_to_the_cart() {
        productPageObjects.ClickOnShoppingCartLink();
    }

    @Given("I checkout the cart")
    public void i_checkout_the_cart() {
        productPageObjects.ClickOnTermsAndConditionsCheckbox();
        productPageObjects.click_on_checkout_button();
    }

    @Given("I add billing address as below and proceed next")
    public void i_add_billing_address_as_below_and_proceed_next(Map<String, String> billingInfo) throws InterruptedException {
        productPageObjects.enter_firstName(billingInfo.get("FirstName"));
        productPageObjects.enter_LastName(billingInfo.get("SecondName"));
        productPageObjects.select_country(billingInfo.get("Country"));
        productPageObjects.enter_city(billingInfo.get("City"));
        productPageObjects.enter_Address(billingInfo.get("Address"));
        productPageObjects.enter_zipcode(billingInfo.get("zipCode"));
        productPageObjects.enter_phone(billingInfo.get("phone"));
        productPageObjects.clickOnContinue();
    }

    @Given("I select shipping address same as Billing address and proceed next")
    public void i_select_shipping_address_same_as_billing_address_and_proceed_next() {
        productPageObjects.select_shippingAddress_SameAs_BillingAddress();
        productPageObjects.click_on_continue();
    }

    @Given("I select Shipping Method as Next Day Air and proceed next")
    public void i_select_shipping_method_as_next_day_air_and_proceed_next() {
        productPageObjects.select_shipping_method();
    }

    @Given("I select payment method as Purchase Order and proceed next")
    public void i_select_payment_method_as_purchase_order_and_proceed_next() {
        productPageObjects.select_payment_method();
    }

    @Given("I enter Payment Number as {string} and process next")
    public void i_enter_payment_number_as_and_process_next(String string) {
        productPageObjects.enter_purchaseOrder_No(string);
    }

    @When("I enter confirm order")
    public void i_enter_confirm_order() {
        productPageObjects.click_on_confirm();
    }

    @Then("Order is successfully placed and Thank you message is displayed")
    public void order_is_successfully_placed_and_thank_you_message_is_displayed() {
        productPageObjects.order_is_successfully_placed_and_thank_you_message_is_displayed();
    }

    @Then("Order number is displayed")
    public void order_number_is_displayed() {
        productPageObjects.order_number_displayed();
    }

    @Given("I click on login link and navigate to login page")
    public void i_click_on_login_link_and_navigate_to_login_page() {
        registerPageObjects.clickOnLoginLink();
    }

    @When("I enter valid email as {string} and valid password as {string}")
    public void i_enter_valid_email_as_and_valid_password_as(String string, String string2) {
        registerPageObjects.enter_email_and_password_as(string, string2);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        registerPageObjects.clickOnLoginButton();
    }

    @Then("I should be navigated to home page from login page")
    public void i_should_be_navigated_to_home_page_from_login_page() {
        registerPageObjects.validatePageTitle();
    }

    @When("I enter valid email as {string} and invalid password as {string}")
    public void i_enter_valid_email_as_and_invalid_password_as(String string, String string2) {
        registerPageObjects.enter_email_and_password_as(string, string2);
    }

    @Then("I should not be navigated to home page from login page")
    public void i_should_not_be_navigated_to_home_page_from_login_page() {
        registerPageObjects.validate_Page_Title();
    }
}
