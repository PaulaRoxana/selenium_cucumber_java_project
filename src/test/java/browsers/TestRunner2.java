package browsers;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"browsers/stepdefinitions"},
        tags = "@Smoke and @Regression",
        plugin = {"pretty"}
)
public class TestRunner2 extends AbstractTestNGCucumberTests {

}
