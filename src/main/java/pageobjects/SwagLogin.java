package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

@DefaultUrl("https://www.saucedemo.com/")
public class SwagLogin extends PageObject {

    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String VALID_CREDENTIALS = "VALID";
    private static final String INVALID_CREDENTIALS = "INVALID";

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement userPasswordInput;

    @FindBy(id = "login-button")
    private WebElement submitButton;

    @FindBy(css = "div[class='error-message-container error'] h3")
    private WebElement errorMessage;

    public SwagLogin(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        this.setImplicitTimeout(15, SECONDS);
        this.open();
        waitLoad();
    }

    public void waitLoad() {
        this.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public void enterValidCredentials() throws IOException {
        Map<String, String> dataMap = readCredentials(VALID_CREDENTIALS);
        userNameInput.sendKeys(dataMap.get(USERNAME_KEY));
        userPasswordInput.sendKeys(dataMap.get(PASSWORD_KEY));
        clickOn(submitButton);
    }

    public void enterInvalidCredentials() throws IOException {
        Map<String, String> dataMap = readCredentials(INVALID_CREDENTIALS);
        userNameInput.sendKeys(dataMap.get(USERNAME_KEY));
        userPasswordInput.sendKeys(dataMap.get(PASSWORD_KEY));
        clickOn(submitButton);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public Map<String, String> readCredentials(String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream("src\\test\\resources\\credentials\\credentials.xls"); HSSFWorkbook wb = new HSSFWorkbook(fis)) {
            HSSFSheet sheet = wb.getSheet(sheetName);
            Map<String, String> dataMap = new HashMap<>();
            for (Row row : sheet) {
                Cell valueCell = row.getCell(1);
                Cell keyCell = row.getCell(0);
                String value = valueCell.getStringCellValue().trim();
                String key = keyCell.getStringCellValue().trim();
                dataMap.put(key, value);
            }
            return dataMap;
        }
    }

}
