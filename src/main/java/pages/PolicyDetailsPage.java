package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PolicyDetailsPage extends BasePage {
    public PolicyDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void next(){
        waitUntil(ExpectedConditions.urlContains("policy-details"));
        clickNext();
    }

}
