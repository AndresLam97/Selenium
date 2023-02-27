package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/FeatureFiles",glue="Test",
        monochrome = true, tags = "@LoginPageErrorValidation",plugin= {"html:target/cucumber.html"})
public class LoginPageRunner extends AbstractTestNGCucumberTests {
}
