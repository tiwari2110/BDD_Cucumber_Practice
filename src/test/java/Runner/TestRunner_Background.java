package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/BackgroundDemo/BackgroundFeature.feature", glue = {"BackgroundDemoSteps"},
monochrome = true,
plugin = {"pretty", "json:target/JsonReports/report.json"})
public class TestRunner_Background {

}
