package seleniumtest;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//test dev branch
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:output"},features="src/test/resources/login")
public class RunTest {
}
