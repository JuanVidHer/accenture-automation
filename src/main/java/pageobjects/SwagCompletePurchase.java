package pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagCompletePurchase extends PageObject {

    @FindBy(className = "pony_express")
    private WebElement ponyExpressImage;

    @FindBy(className = "complete-text")
    private WebElement successfulPurchaseMessage;

    public Boolean checkSuccessfulPurchase() {
        return ponyExpressImage.isDisplayed() && successfulPurchaseMessage.isDisplayed();
    }

}
