package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExtrasPage1 extends BasePage {
    public ExtrasPage1(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void next(){
        waitUntil(ExpectedConditions.urlContains("extras-or-tailored-1"));
        clickNext();
    }

}
