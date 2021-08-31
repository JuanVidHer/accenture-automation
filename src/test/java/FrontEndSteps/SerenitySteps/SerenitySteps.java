package FrontEndSteps.SerenitySteps;

import PageObjects.SwagCart;
import PageObjects.SwagCheckoutOverview;
import PageObjects.SwagCompletePurchase;
import PageObjects.SwagInformation;
import PageObjects.SwagLogin;
import PageObjects.SwagResults;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.io.IOException;

public class SerenitySteps {

    private SwagLogin swagLogin;
    private SwagResults swagResults;
    private SwagCart swagCart;
    private SwagInformation swagInformation;
    private SwagCheckoutOverview swagCheckoutOverview;
    private SwagCompletePurchase swagCompletePurchase;

    @Step("Given the user is on the Swag login page")
    public void openLoginSite() {
        swagLogin.openPage();
    }

    @Step("When the user enters valid credentials")
    public void enterValidCredentials() throws IOException {
        swagLogin.enterValidCredentials();
    }

    @Step("When the user enters invalid credentials")
    public void enterInvalidCredentials() throws IOException {
        swagLogin.enterInvalidCredentials();
    }

    @Step("the user navigates successfully to \"([^\"]*)\" page")
    public void verifyLogin(String expectedValue) {
        Assert.assertEquals("The page title matches with expected value.", expectedValue, swagResults.getPageTitle());
    }

    @Step("the pages shows an error message")
    public void checkLoginErrorMessage() {
        Assert.assertEquals("The page title does not match with expected value.",
                "Epic sadface: Username and password do not match any user in this service", swagLogin.getErrorMessage());
    }

    @Step("When the user selects all available items")
    public void selectAllAvailableItems() {
        swagResults.addAllProductsToChart();
    }

    @Step("And the user checkouts the purchase")
    public void checkoutPurchase() {
        swagCart.checkoutPurchase();
    }

    @Step("And the user fills out the shipment form")
    public void fillOutShipmentForm(String firstName, String lastName, String zipCoce) {
        swagInformation.fillOutShipmentForm(firstName, lastName, zipCoce);
    }

    @Step("And the user confirms information is correct")
    public void confirmInformation() {
        swagCheckoutOverview.confirmInfomation();
    }

    @Step("Then successful purchase message is shown")
    public void checkSuccessfulPurchaseMessage() {
        Assert.assertTrue("Purchase has not been completed correctly", swagCompletePurchase.checkSuccessfulPurchase());
    }

}
