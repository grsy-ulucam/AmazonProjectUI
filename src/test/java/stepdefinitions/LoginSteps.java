package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class LoginSteps {

      LoginPage loginPage=new LoginPage(Driver.getDriver());

    @Given("Go to Amazon Website")
    public void goToAmazonWebsite() {

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        loginPage.clickPopButon();

    }

    @Given("Click to account button")
    public void clickToAccountButton()
    {
        loginPage.clickAccountButton();

    }

    @When("Enter valid email and click continue button")
    public void enterValidEmailAndClickContinueButton() {

        loginPage.enterValidEmailandClickContinueButton();

    }

    @And("Enter valid password and click sing in button")
    public void enterValidPasswordAndClickSingInButton() {

        loginPage.enterValidPasswordandClickSingButton();
    }

    @Then("See your username on Home Page")
    public void seeYourUsernameOnHomePage() {

        loginPage.verifyYourAccount();

    }

    @When("Enter invalid  {string} and click continue button")
    public void enterInvalidWithoutAndClickContinueButton(String email)  {

        loginPage.enterInvalidEmailandClickContinueButton(email);

    }
    @Then("Verify error mesaj after continue button")
    public void verifyErrorMesajAfterContinueButton() {

        loginPage.verifyErrorMesajAfterContinueButton();

    }
    @And("Enter invalid {string} and click sing in button")
    public void enterInvalidAndClickSingInButton(String password) {

        loginPage.enterInvalidPasswordandClickSingButton(password);

    }
    @Then("Verify error mesaj after sing in button")
    public void verifyErrorMesajAfterSingInButtonButton() throws IOException {

        loginPage.verifyErrorMesajAfterSingInButtonButton();

    }

}
