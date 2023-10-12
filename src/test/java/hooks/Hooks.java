package hooks;

import io.cucumber.java.After;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {


    @Before

    public void setUp() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @After

    public void tearDown() throws IOException {

       File source = ((FirefoxDriver) Driver.getDriver()).getFullPageScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("test-output\\Screenshots\\amazonFullScreenshot.png"));

        Driver.closeDriver();

    }
}
