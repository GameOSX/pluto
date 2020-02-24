package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentCardsPage extends BasePage {
    public PaymentCardsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(text(),'Enter your card details')]")
    private static WebElement cardPaymentText;

    @FindBy(xpath = ".//*[contains(@class,'paypal-btn-logo')]")
    private static WebElement paypalBtn;

    public Boolean verifyPage() {
        driver.navigate().refresh();
        waitUntil(ExpectedConditions.urlContains("payment-cards"));
        return driver.getPageSource().contains("Enter your card details");
    }

/*    public boolean questionModal() {
        waitUntil(ExpectedConditions.urlContains("payment-cards"));
        return driver.getPageSource().contains("Everything ok");
    }

    public void closeQuestionModal() {
        closeQuestionModalLocator.click();
    }*/

    public boolean verifyPaypalIsAvailable() {
        waitUntil(ExpectedConditions.urlContains("payment-cards"));
        return paypalBtn.isDisplayed();
    }
}
