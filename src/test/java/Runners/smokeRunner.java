package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Google Drive\\PIIT\\IntellijCodes\\CNNBDD\\src\\Resources\\checktabs.feature",
glue = {"StepDefinitions"}, format = {"pretty", "html:targt/cucumber"}, tags = "@Smoke"
)


public class smokeRunner {
}
