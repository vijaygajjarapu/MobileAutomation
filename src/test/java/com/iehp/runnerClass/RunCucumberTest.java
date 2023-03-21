package com.iehp.runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/com.iehp.features"},tags="@sss",
        glue = "com.iehp",
        plugin = {"pretty", "json:target/cucumber-reports/report.json", "html:target/cucumber-reports/report.html"}
)

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}