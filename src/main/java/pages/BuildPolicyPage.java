package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BuildPolicyPage extends BasePage {
    public BuildPolicyPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(text(),'Two ways to get a quote')]")
    private static WebElement twoWaysOfQuote;

    @FindBy(xpath = ".//*[contains(text(),'3 mins')]")
    private static WebElement plutoSpecialLocator;

    public void next(){
        waitUntil(ExpectedConditions.urlContains("build-your-policy"));
        clickNext();
    }

    public boolean twoWaysOfQuoteIsDisplayed(){
        waitUntil(ExpectedConditions.urlContains("build-your-policy"));
        return driver.getPageSource().contains("Two ways to get a quote");
    }

    public void selectPlutoSpecial() {
        plutoSpecialLocator.click();
    }
}
