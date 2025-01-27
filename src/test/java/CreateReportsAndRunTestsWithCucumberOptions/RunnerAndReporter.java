package CreateReportsAndRunTestsWithCucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml",
                "pretty"
        },
        features = "src/test/resources/ChromeFeatures",
        glue = "StepDefinitions",
        tags = "@AnadoluSigorta",
        dryRun = false
)
public class RunnerAndReporter extends AbstractTestNGCucumberTests {

}