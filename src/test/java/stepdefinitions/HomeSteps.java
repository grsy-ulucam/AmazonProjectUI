package stepdefinitions;

import io.cucumber.java.en.When;
import pages.HomePage;

import utilities.Driver;

public class HomeSteps {

    HomePage homePage=new HomePage(Driver.getDriver());

    @When("Search a {string} in search bar on home page")
    public void searchAInSearchBarOnHomePage(String product) {
        homePage.searchBook(product);
    }
}
