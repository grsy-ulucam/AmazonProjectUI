package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addBasketButton;

    @FindBy(xpath = "//*[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    private WebElement  completeTextBasket;

    @FindBy(id= "nav-cart-count")
    private WebElement basketArea;

    @FindBy(xpath= "(//label[text()='Mktr:']/following::input)[2]")
    private WebElement deleteButtonInBasket;

    public void clickAddBasket() {

        ReusableMethods.jseWithClick(driver,addBasketButton);

    }

    public void checkTextCompleteBasket() {

        Assert.assertEquals("Sepete Eklendi",ReusableMethods.getElementText(completeTextBasket));
        ReusableMethods.hover(basketArea);
        ReusableMethods.jseWithClick(driver,basketArea);
        ReusableMethods.hover(deleteButtonInBasket);
        ReusableMethods.jseWithClick(driver,deleteButtonInBasket);

    }
}
