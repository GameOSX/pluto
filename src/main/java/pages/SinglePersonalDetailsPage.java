package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SinglePersonalDetailsPage extends BasePage{
    public SinglePersonalDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='username']")
    private static WebElement fullNameLocator;

    @FindBy(xpath = ".//*[@id='age']")
    private static WebElement ageLocator;

    @FindAll(@FindBy(xpath = ".//input[@name='medical']"))
    private static List<WebElement> dontGaveMedicalConditionsLocator;

    @FindAll(@FindBy(xpath = ".//*[contains(text(), 'Please provide your full name')]"))
    private static List<WebElement> validationName;

    @FindAll(@FindBy(xpath = ".//*[contains(text(), 'last name too')]"))
    private static List<WebElement> validationLastName;

    @FindAll(@FindBy(xpath = ".//*[contains(text(),'aged 18 - 46')]"))
    private static List<WebElement> validationAge;

    public  void insertFullName(String fullName) {
        waitUntil(ExpectedConditions.visibilityOf(fullNameLocator));
        fullNameLocator.sendKeys(fullName);
    };

    public void insertAge(String age) {
        ageLocator.sendKeys(age);
    }

    public void selectDontHavePreExistingMedicalConditions() {
        dontGaveMedicalConditionsLocator.get(0).click();
    }

    public void next() {
        clickNext();
    }

    public boolean validationIsNotDisplayed() {
        if (validationName.size()>0 || validationLastName.size()>0 || validationAge.size()>0){
            return false;
        } else {
            return true;
        }
    }
}
