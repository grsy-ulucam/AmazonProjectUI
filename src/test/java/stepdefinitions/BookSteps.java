package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookPage;
import utilities.Driver;

public class BookSteps {

    BookPage bookPage=new BookPage(Driver.getDriver());

    @Then("Verify book in search on book page")
    public void verifyBookInSearchOnResultPage() {

        bookPage.checkResultBook();

    }

    @When("Click first book on book page")
    public void clickFirstProductOnResultPage() {

        bookPage.clickFirstBook();

    }






}
