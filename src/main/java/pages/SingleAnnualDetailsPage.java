package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingleAnnualDetailsPage extends BasePage{
    public SingleAnnualDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(text(),'Country')]")
    private WebElement countryLocator;

    @FindBy(xpath = ".//*[@id='country-0']//input[@id='react-select-2-input']")
    private static WebElement countryInputLocator;

    public void insertCountry(String country) {
        waitUntil(ExpectedConditions.visibilityOf(nextLocator));
        countryLocator.click();
        countryInputLocator.sendKeys(country);
        countryInputLocator.sendKeys(Keys.RETURN);
    }

    public void next() {
        clickNext();
    }
}
