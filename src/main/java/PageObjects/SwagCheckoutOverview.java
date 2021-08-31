package PageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagCheckoutOverview extends PageObject {

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void confirmInfomation() {
        finishButton.click();
    }
}
