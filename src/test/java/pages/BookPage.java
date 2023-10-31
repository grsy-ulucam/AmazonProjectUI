package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class BookPage {

    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='search']//span[3]")
    private WebElement bookResult;

    @FindBy(xpath = "(//div[contains(@class,'a-section aok-relative')]//img)[1]")
    private WebElement firstBook;

    @FindBy(xpath= "//img[@data-image-index='49']")
    private WebElement lastBook;

    @FindBy(id = "a-autoid-0-announce")
    private WebElement sortByButton;

    @FindBy(css = "a#s-result-sort-select_1")
    private  WebElement lowToHighButton;

    @FindBy(xpath = "(//a[contains(@class,'a-link-normal s-underline-text')]//span)[1]")
    private  WebElement motherBook;

    public void checkResultBook() {

        Assert.assertTrue(ReusableMethods.getElementText(bookResult).contains("book"));
    }

    public void clickFirstBook() {

        ReusableMethods.jseWithClick(driver, firstBook);
    }


    public void clickLastBook() {

      ReusableMethods.scrollAndClickElement(driver,lastBook);
    }

    public void seeAndClickSortByButton() {

        Assert.assertTrue(ReusableMethods.getElementText(bookResult).contains("book"));
        ReusableMethods.hover(sortByButton);
        ReusableMethods.jseWithClick(driver,sortByButton);
    }

    public void selectLowtoHigh() {

        ReusableMethods.jseWithClick(driver,lowToHighButton);
    }

    public void verifyBookName(String name) {

        Assert.assertTrue(ReusableMethods.getElementText(motherBook).equals(name));

    }
}
