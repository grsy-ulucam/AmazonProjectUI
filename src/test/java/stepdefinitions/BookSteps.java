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


    @And("Click last book on book page")
    public void clickLastBookOnBookPage() {

        bookPage.clickLastBook();

    }


    @And("Should see on book page and click sort by button on book page")
    public void shouldSeeOnBookPageAndClickSortByButtonOnBookPage() {
        bookPage.seeAndClickSortByButton();
    }

    @And("Select low to high on book page")
    public void selectLowToHighOnBookPage() {
        bookPage.selectLowtoHigh();
    }

    @Then("Verify {string} on book page")
    public void verifyOnBookPage(String name) {
        bookPage.verifyBookName(name);
    }
}
