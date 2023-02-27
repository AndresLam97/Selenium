package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/FeatureFiles",glue = "Test", tags = "@Regression", monochrome = true, plugin = {"html:target/cucumber.html"})
public class LoginPageRunnerRegression extends AbstractTestNGCucumberTests {
}
