package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class QuotesPage extends BasePage {
    public QuotesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(text(),'Your quotes')]")
    private static WebElement yourQuotesLocator;

    @FindAll(@FindBy(xpath = ".//*[contains(text(),'View more details')] | .//*[contains(text(),'Select')]"))
    private static List<WebElement> singleTripQuoteLocator;

    public void next(){
        waitUntil(ExpectedConditions.urlContains("quotes"));
        clickNext();
    }

    public void selectSingleTripQuote() {
        waitUntil(ExpectedConditions.visibilityOf(yourQuotesLocator));
        singleTripQuoteLocator.get(0).click();
    }
}
