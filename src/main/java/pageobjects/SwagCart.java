package pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagCart extends PageObject {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public void checkoutPurchase() {
        checkoutButton.click();
    }

}
