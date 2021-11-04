package com.saucedemo.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber2.json"
        },
        features = {
                "src/test/resources/features"
        },
        glue = "com/saucedemo/step_definitions",
        dryRun = false,
        tags = "",
        publish = true
)
public class CucumberRunnerForIOS {

}


