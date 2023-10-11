package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasketPage;
import utilities.Driver;

public class BasketSteps {

    BasketPage basketPage=new BasketPage(Driver.getDriver());

    @And("Click add the basket on basket page")
    public void clickAddTheBasketOnBasketPage() {
        basketPage.clickAddBasket();
    }

    @Then("Verify text about add the basket on basket page")
    public void verifyTextAboutAddTheBasketOnBasketPage() {
       basketPage.checkTextCompleteBasket();
    }
}
