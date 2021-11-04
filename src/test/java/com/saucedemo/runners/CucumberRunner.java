package com.saucedemo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "timeline:target/timeline-report"
        },
        features = {
                "src\\test\\resources\\features"
        },
        glue = "com\\saucedemo\\step_definitions",
        dryRun = true,
        tags = "",
        publish = true
)
public class CucumberRunner {

}
