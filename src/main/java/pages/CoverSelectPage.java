package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CoverSelectPage extends BasePage {
    public CoverSelectPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = ".//button"))
    private List<WebElement> coverSelectorLocator;

    public void selectSingleTripCover() {
        coverSelectorLocator.get(1).click();
    }

    public void selectAnnualCover() {
        coverSelectorLocator.get(0).click();
    }
}
