package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExtrasPage3 extends BasePage {
    public ExtrasPage3(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void next(){
        waitUntil(ExpectedConditions.urlContains("extras-or-tailored-3"));
        clickNext();
    }

}
