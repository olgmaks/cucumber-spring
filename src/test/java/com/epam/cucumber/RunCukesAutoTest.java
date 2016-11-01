package com.epam.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "src/test/resources/features/base.feature",
        glue = {"com.epam.stepdefs"},
        format = {"pretty"})
@RunWith(Cucumber.class)
public class RunCukesAutoTest {
}



