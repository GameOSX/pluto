package pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(final WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button//*[contains(text(),'Next')]")
    public static WebElement nextLocator;

    public <A> void waitUntil(final ExpectedCondition<A> conditions) {
        final WebDriverWait w8 = new WebDriverWait(driver, Duration.ofSeconds(20));
        w8.until(conditions);
    }

    public void clickNext() {
        waitUntil(ExpectedConditions.elementToBeClickable(nextLocator));
        nextLocator.click();
    }


}
