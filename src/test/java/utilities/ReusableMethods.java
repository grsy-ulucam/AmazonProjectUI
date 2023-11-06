package utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class ReusableMethods {

        public static void scrollToElement(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean verifyTextInList(List<String> textList, String targetText) {
        for (String text : textList) {
            if (text != null && text.equals(targetText)) {
                Assert.assertEquals(targetText,text);
                return true;
            }
        }
        return false;
    }


    public static void selectOptionByValue(WebDriver driver, WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void scrollAndClickElement(WebDriver driver, WebElement element) {
        // Elementin görünmesini sağlamak için JavaScript kullanarak sayfayı kaydır
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Elemente tıkla
        element.click();
    }


    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void sendKeyWithEnterJS(WebDriver driver, WebElement element, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value = arguments[1]", element, text);

        // Simulate pressing the Enter key using Keys.ENTER
        element.sendKeys(Keys.ENTER);
    }

    public static String getElementText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void jseWithClick(WebDriver driver, WebElement element) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);

    }

    public static void doubleClickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        new Actions(utilities.Driver.getDriver()).doubleClick(element).build().perform();
    }

    public static void sendKeysWithJS(WebDriver driver, WebElement element, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value = arguments[1]", element, text);
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(utilities.Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static String getScreenshot(String name) throws IOException {

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) utilities.Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);

        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(utilities.Driver.getDriver(), Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }




    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = utilities.Driver.getDriver().getWindowHandle();
        for (String handle : utilities.Driver.getDriver().getWindowHandles()) {
            utilities.Driver.getDriver().switchTo().window(handle);
            if (utilities.Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        utilities.Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over=====//


    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = utilities.Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //   HARD WAIT ==> THREAD.SLEEP ile
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(utilities.Driver.getDriver(), Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(utilities.Driver.getDriver(), Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(utilities.Driver.getDriver(), Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(utilities.Driver.getDriver(), Duration.ofSeconds(3));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {

        FluentWait<WebDriver> wait = new FluentWait<>(utilities.Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1));

        WebElement element;
        element = wait.until(driver -> webElement);

        return element;
    }




    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }



    //a method calculates days between two dates
    public static Boolean daysBetweenDates(String dateStr) {
        boolean newborn = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        LocalDate currentDate = LocalDate.now();
        int daysBetween = (int) ChronoUnit.DAYS.between(localDate, currentDate);
        if (daysBetween <= 30 && daysBetween >= 0) {
            newborn = true;
        }
        return newborn;
    }




    public static void scrollPageDownWithJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,25)", "");
    }




    public static long periodBetweenDates(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = localDate.until(currentDate);
        return period.getYears() * 365L + period.getMonths() * 30L + period.getDays();
    }

    public static WebElement locateServiceByText(String text) {
        return utilities.Driver.getDriver().findElement(By.xpath("//*[contains(@id,'lstServis_DXMainTable')]//td[contains(.,'" + text + "')]"));
    }

    public static WebElement locatePatientByText(String text) {
        return utilities.Driver.getDriver().findElement(By.xpath("//*[contains(@id,'dxGridHastaListe_DXMainTable')]//td[contains(.,'" + text + "')]"));
    }


    public static WebElement locateSelectHallByText(String text) {
        return utilities.Driver.getDriver().findElement(By.xpath("//*[contains(@id,'lstSalonMasaListesi_DXData')]//td[contains(.,'" + text + "')]"));
    }


    public static WebElement locateHallOptionsByText(String text) {
        return utilities.Driver.getDriver().findElement(By.xpath("//div[@class='content blckAcilirMenu']//a[contains(.,'" + text + "')]"));
    }

    public static WebElement locateChangeHallByText(String text) {
        return utilities.Driver.getDriver().findElement(By.xpath("//table[@id='SALONDEG_DXMainTable']//td[contains(.,'" + text + "')]"));
    }

    public static WebElement locateSelectChangeHallByText(String text) {
        return utilities.Driver.getDriver().findElement(By.xpath("//div[@class='content blckAcilirMenu']//a[contains(.,'" + text + "')]"));
    }

    public static void clickCurrentPage(int p) throws InterruptedException {
        String pageNumberCountText = Integer.toString(p);
        WebElement pageNumberNext = utilities.Driver.getDriver().findElement(By.xpath("//div[@id='lstServis_DXPagerBottom']//*[contains(@class,'dxp-num')][text()='" + pageNumberCountText + "']"));
        ReusableMethods.jseWithClick(utilities.Driver.getDriver(), pageNumberNext);
      //  CreateSurgeryList_Page surgeryList_Page = new CreateSurgeryList_Page();
      // ReusableMethods.jseWithClick(utilities.Driver.getDriver(), CreateSurgeryList_Page.refreshButton);
        Thread.sleep(2000);
    }


}