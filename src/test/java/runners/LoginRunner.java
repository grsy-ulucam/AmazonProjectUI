package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Login.feature"},
        glue = {"stepdefinitions","hooks"},
        plugin = {"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber-json.json",
                "junit:target/cucumber-xml.xml",
                "pretty"
        }
)
public class LoginRunner {
}
