package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeaturesWithTags/Tags.feature", glue = {"StepDefinitions"},
tags = "@Smoke")
public class TestRunner_RunWithSingleTag {

}
