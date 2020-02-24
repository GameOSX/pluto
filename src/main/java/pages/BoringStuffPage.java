package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoringStuffPage extends BasePage {
    public BoringStuffPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(text(),'I confirm')]")
    private WebElement termsCheckLocator;

    @FindBy(xpath = ".//*[contains(text(),'I accept')]")
    private WebElement privaciesCheckLocator;

    @FindBy(xpath = ".//*[contains(text(),'Proceed to payment')]")
    private WebElement proceedPaymentLocator;

    public void next(){
        waitUntil(ExpectedConditions.urlContains("boring-stuff"));
        clickNext();
    }

    public void selectTerms() {
        waitUntil(ExpectedConditions.visibilityOf(termsCheckLocator));
        termsCheckLocator.click();
    }

    public void selectPrivacies() {
        waitUntil(ExpectedConditions.visibilityOf(privaciesCheckLocator));
        privaciesCheckLocator.click();
    }

    public void proceedPayment(){
        waitUntil(ExpectedConditions.elementToBeClickable(proceedPaymentLocator));
        proceedPaymentLocator.click();
    }
}
