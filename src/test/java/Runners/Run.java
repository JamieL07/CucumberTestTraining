package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/JSONReport/report.json",
                "junit:target/JunitReport/report.xml"},
        tags = "@smoketest or @Regression"

)
public class Run extends AbstractTestNGCucumberTests {
}
