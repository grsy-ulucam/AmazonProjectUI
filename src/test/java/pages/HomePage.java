package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    public void searchBook(String product) {
        ReusableMethods.jseWithClick(driver,searchBox);
        ReusableMethods.sendKeyWithEnterJS(driver,searchBox,product);
    }
}
