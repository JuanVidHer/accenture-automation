package FrontEndSteps;

import FrontEndSteps.SerenitySteps.SerenitySteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class StepsDefinitions {

    @Steps
    SerenitySteps serenitySteps;

    @Given("^the user is on the Swag login page$")
    public void theUserIsOnTheSwagLoginPage() {
        serenitySteps.openLoginSite();
    }

    @When("^the user enters valid credentials$")
    public void theUserEntersValidCredentials() throws IOException {
        serenitySteps.enterValidCredentials();
    }

    @When("^the user enters invalid credentials$")
    public void theUserEntersInvalidCredentials() throws IOException {
        serenitySteps.enterInvalidCredentials();
    }

    @Then("^the user navigates successfully to '(.*)' page$")
    public void theLoginIsSuccessful(String expectedValue) {
        serenitySteps.verifyLogin(expectedValue);
    }

    @Then("^the pages shows an error message$")
    public void theLoginIsUnsuccessful() {
        serenitySteps.checkLoginErrorMessage();
    }

    @When("^the user selects all available items$")
    public void theUserSelectsAllAvailableItems() {
        serenitySteps.selectAllAvailableItems();
    }

    @And("^the user checkouts the purchase$")
    public void theUserCheckoutsThePurchase() {
        serenitySteps.checkoutPurchase();
    }

    @And("^the user fills out the shipment form with first name '(.*)', last name '(.*)' and zip code '(.*)'$")
    public void theUserFillsOutTheShipmentForm(String firstName, String lastName, String zipCode) {
        serenitySteps.fillOutShipmentForm(firstName, lastName, zipCode);
    }

    @And("the user confirms information is correct")
    public void theUserConfirmsInformationIsCorrect() {
        serenitySteps.confirmInformation();
    }

    @Then("successful purchase message is shown")
    public void successfulPurchaseMessageIsShown() {
        serenitySteps.checkSuccessfulPurchaseMessage();
    }
}
