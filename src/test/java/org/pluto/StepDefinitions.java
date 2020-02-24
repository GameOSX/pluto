package org.pluto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.assertj.core.api.Assertions.*;

public class StepDefinitions {

    private WebDriver driver;
    CoverSelectPage coverSelectPage;
    SingleAnnualDetailsPage singleAnnualDetailsPage;
    SinglePersonalDetailsPage singlePersonalDetailsPage;
    BuildPolicyPage buildPolicyPage;
    ExtrasPage1 extrasPage1;
    ExtrasPage2 extrasPage2;
    ExtrasPage3 extrasPage3;
    ExtrasPage4 extrasPage4;
    MedicalLimistPage medicalLimistPage;
    ExtrasPage extrasPage;
    QuotesPage quotesPage;
    PolicyDetailsPage policyDetailsPage;
    BoringStuffPage boringStuffPage;
    PaymentPage paymentPage;
    PaymentCardsPage paymentCardsPage;
    AnnualSinglePage annualSinglePage;

    @Before
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    };

    @Given("I want to buy cover for single trip")
    public void i_want_to_buy_cover_for_single_trip() {
        driver.get("https://pluto-customer-web-app-staging.herokuapp.com/tailored-annual-or-single");
    }

    @When("I select cover for single trip")
    public void i_select_cover_for_single_trip() {
        coverSelectPage = new CoverSelectPage(driver);
        coverSelectPage.selectSingleTripCover();
    }

    @When("I fill all required data")
    public void i_fill_all_required_data() {
        singleAnnualDetailsPage = new SingleAnnualDetailsPage(driver);
        singlePersonalDetailsPage = new SinglePersonalDetailsPage(driver);
        buildPolicyPage = new BuildPolicyPage(driver);
        extrasPage1 = new ExtrasPage1(driver);
        extrasPage2 = new ExtrasPage2(driver);
        extrasPage3 = new ExtrasPage3(driver);
        extrasPage4 = new ExtrasPage4(driver);
        extrasPage = new ExtrasPage(driver);
        medicalLimistPage = new MedicalLimistPage(driver);
        singleAnnualDetailsPage.insertCountry("Poland");
        singleAnnualDetailsPage.next();
        singlePersonalDetailsPage.insertFullName("John Doe");
        singlePersonalDetailsPage.insertAge("30");
        singlePersonalDetailsPage.selectDontHavePreExistingMedicalConditions();
        singlePersonalDetailsPage.next();
        if (buildPolicyPage.twoWaysOfQuoteIsDisplayed()){
            buildPolicyPage.selectPlutoSpecial();
        } else {
            buildPolicyPage.next();
        }
        extrasPage1.next();
        extrasPage2.next();
        extrasPage3.next();
        extrasPage4.next();
        medicalLimistPage.next();
        extrasPage.next();
    }

    @When("I select quote for single trip")
    public void i_select_quote_for_single_trip(){
        quotesPage = new QuotesPage(driver);
        policyDetailsPage = new PolicyDetailsPage(driver);
        boringStuffPage = new BoringStuffPage(driver);
        quotesPage.selectSingleTripQuote();
        policyDetailsPage.next();
        boringStuffPage.selectTerms();
        boringStuffPage.selectPrivacies();
        boringStuffPage.proceedPayment();
    }

    @Then("I will be able to buy such a cover with a card payment")
    public void i_will_be_able_to_buy_such_a_cover_with_a_card_payment() {
        paymentPage = new PaymentPage(driver);
        paymentCardsPage = new PaymentCardsPage(driver);
        paymentPage.enterEmail("jdoe@gmail.com");
        paymentPage.selectCardPayment();
        assertThat(paymentCardsPage.verifyPage()).isTrue();

        driver.close();
    }


    @Given("I want to buy cover for a year")
    public void i_want_to_buy_cover_for_a_year() {
        driver.get("https://pluto-customer-web-app-staging.herokuapp.com/tailored-annual-or-single");
    }

    @When("I select annual cover")
    public void i_select_annual_cover() {
        coverSelectPage = new CoverSelectPage(driver);
        coverSelectPage.selectAnnualCover();
    }

    @When("I fill required data for worldwide")
    public void i_fill_required_data_for_worldwide() {
        annualSinglePage = new AnnualSinglePage(driver);
        singlePersonalDetailsPage = new SinglePersonalDetailsPage(driver);
        buildPolicyPage = new BuildPolicyPage(driver);
        extrasPage1 = new ExtrasPage1(driver);
        extrasPage2 = new ExtrasPage2(driver);
        extrasPage3 = new ExtrasPage3(driver);
        extrasPage4 = new ExtrasPage4(driver);
        extrasPage = new ExtrasPage(driver);
        medicalLimistPage = new MedicalLimistPage(driver);
        annualSinglePage.next();
        singlePersonalDetailsPage.insertFullName("Mr Smith");
        singlePersonalDetailsPage.insertAge("40");
        singlePersonalDetailsPage.selectDontHavePreExistingMedicalConditions();
        singlePersonalDetailsPage.next();
        if (buildPolicyPage.twoWaysOfQuoteIsDisplayed()){
            buildPolicyPage.selectPlutoSpecial();
        } else {
            buildPolicyPage.next();
        }
        extrasPage1.next();
        extrasPage2.next();
        extrasPage3.next();
        extrasPage4.next();
        medicalLimistPage.next();
        extrasPage.next();
    }

    @Then("I will get annual quote proposition")
    public void i_will_get_annual_quote_proposition() {
        quotesPage = new QuotesPage(driver);
        policyDetailsPage = new PolicyDetailsPage(driver);
        boringStuffPage = new BoringStuffPage(driver);
        quotesPage.selectSingleTripQuote();
        policyDetailsPage.next();
        boringStuffPage.selectTerms();
        boringStuffPage.selectPrivacies();
        boringStuffPage.proceedPayment();
    }

    @Then("Will be able to pay for if via paypal")
    public void will_be_able_to_pay_for_it_via_paypal(){
        paymentPage = new PaymentPage(driver);
        paymentCardsPage = new PaymentCardsPage(driver);
        paymentPage.enterEmail("jdoe@gmail.com");
        assertThat(paymentPage.verifyPaypalIsAvailable()).isTrue();

        driver.close();
    }

    @Given("I want to check validation for name and age")
    public void i_want_to_check_validation_for_name_and_age() {
        annualSinglePage = new AnnualSinglePage(driver);
        driver.get("https://pluto-customer-web-app-staging.herokuapp.com/tailored-annual-or-single");
        coverSelectPage = new CoverSelectPage(driver);
        coverSelectPage.selectAnnualCover();
        annualSinglePage.next();
    }

    @When("I fill {string} and {string}")
    public void i_fill_and(String name, String age) {
        singlePersonalDetailsPage = new SinglePersonalDetailsPage(driver);
        singlePersonalDetailsPage.insertFullName(name);
        singlePersonalDetailsPage.insertAge(age);
        singlePersonalDetailsPage.selectDontHavePreExistingMedicalConditions();
    }

    @Then("I will get proper {string}")
    public void i_will_get_proper(String validation) {
        assertThat(singlePersonalDetailsPage.validationIsNotDisplayed()).isEqualTo(Boolean.valueOf(validation));

        driver.close();
    }


}


