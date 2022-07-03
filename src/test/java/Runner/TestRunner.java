package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/login.feature", glue = {"StepDefinitions"},
monochrome = true,
plugin = {"pretty", "json:target/JsonReports/report.json"},
tags = "@Smoke")
public class TestRunner {

}
