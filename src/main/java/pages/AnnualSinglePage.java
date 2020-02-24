package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AnnualSinglePage extends BasePage{
    public AnnualSinglePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void next() {
        clickNext();
    }
}
