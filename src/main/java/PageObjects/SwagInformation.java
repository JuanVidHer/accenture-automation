package PageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagInformation extends PageObject {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void fillOutShipmentForm(String firstName, String lastName, String zipCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(zipCode);
        continueButton.click();
    }

}
