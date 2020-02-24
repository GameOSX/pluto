package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='email']")
    private static WebElement emailFieldLocator;

    @FindBy(xpath = ".//*[@id='paymentTypeCard']")
    private static WebElement cardPaymentLocator;

    @FindBy(xpath = ".//*[contains(@class,'paypal-btn-logo')]")
    private static WebElement paypalBtn;

    public void next(){
        waitUntil(ExpectedConditions.urlContains("payment"));
        clickNext();
    }

    public void enterEmail(String email) {
        waitUntil(ExpectedConditions.visibilityOf(emailFieldLocator));
        emailFieldLocator.sendKeys(email);
    }

    public void selectCardPayment(){
        cardPaymentLocator.click();
    }

    public boolean verifyPaypalIsAvailable() {
        waitUntil(ExpectedConditions.urlContains("payment"));
        return paypalBtn.isDisplayed();
    }
}
