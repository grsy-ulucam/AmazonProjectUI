package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class BookPage {

    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='search']//span[3]")
    private WebElement bookResult;

    @FindBy(xpath = "(//*[@id='search']//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    private WebElement firstBook;



    public void checkResultBook() {

        Assert.assertTrue(ReusableMethods.getElementText(bookResult).contains("book"));

    }
    public void clickFirstBook() {

        ReusableMethods.jseWithClick(driver,firstBook);
    }


}
