package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.io.IOException;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sp-cc-accept")
    private WebElement popButton;
    @FindBy(xpath = "//*[@id='nav-link-accountList']")
    private WebElement accountButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailArea;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordArea;

    @FindBy(id = "signInSubmit")
    private WebElement singButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@id='nav-item-signout']/span")
    private WebElement exitButton;

    @FindBy(className = "a-list-item")
    private WebElement errorMesajAboutEmail;

    @FindBy(xpath = "//*[@id='auth-error-message-box']//span")
    private WebElement errorMesajAboutPassword;

    public void clickPopButon() {
        ReusableMethods.jseWithClick(driver,popButton);
    }
    public void clickAccountButton() {


        ReusableMethods.jseWithClick(driver,accountButton);

    }

    public void enterValidEmailandClickContinueButton() {

        ReusableMethods.sendKeysWithJS(driver,emailArea, ConfigReader.getProperty("email"));
        ReusableMethods.jseWithClick(driver,continueButton);

    }

    public void enterValidPasswordandClickSingButton() {

        ReusableMethods.sendKeysWithJS(driver,passwordArea,ConfigReader.getProperty("password"));
        ReusableMethods.jseWithClick(driver,singButton);

    }

    public void verifyYourAccount() {
       Assert.assertEquals(ConfigReader.getProperty("username"),ReusableMethods.getElementText(myAccount));
       ReusableMethods.hover(myAccount);
       ReusableMethods.jseWithClick(driver,exitButton);
    }

    public void enterInvalidEmailandClickContinueButton(String email)  {

        ReusableMethods.sendKeysWithJS(driver,emailArea, String.valueOf(email));
        ReusableMethods.jseWithClick(driver,continueButton);

    }

    public void verifyErrorMesajAfterContinueButton() {

        Assert.assertTrue(ReusableMethods.getElementText(errorMesajAboutEmail).contains("Bu e-posta adresiyle bir hesap bulamıyoruz"));

    }
    public void enterInvalidPasswordandClickSingButton(String password)  {

        ReusableMethods.sendKeysWithJS(driver,passwordArea,password);
        ReusableMethods.jseWithClick(driver,singButton);

    }

    public void verifyErrorMesajAfterSingInButtonButton()  {

        Assert.assertTrue(ReusableMethods.getElementText(errorMesajAboutPassword).contains("Şifreniz yanlış"));

    }

}
