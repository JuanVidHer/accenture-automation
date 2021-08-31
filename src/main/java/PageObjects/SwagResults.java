package PageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwagResults extends PageObject {

    @FindBy(css = "span[class='title']")
    private WebElement resultsPageTitle;

    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> addToChartButtons;

    @FindBy(css = "a[class='shopping_cart_link']")
    private WebElement shoppingCartButton;

    public String getPageTitle() {
        return resultsPageTitle.getText();
    }

    public void addAllProductsToChart() {
        for(WebElement button : addToChartButtons) {
            button.click();
        }
        shoppingCartButton.click();
    }

}
