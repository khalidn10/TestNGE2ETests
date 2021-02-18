package cucumber_options;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
					//plugin = "pretty",
					features = "src/test/java/features",
					glue = "step_definitions"
					//,dryRun = true
				)
public class TestRunner extends AbstractTestNGCucumberTests {

}
