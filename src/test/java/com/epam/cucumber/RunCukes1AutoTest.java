package com.epam.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by OLEG on 01.11.2016.
 */
@CucumberOptions(
        features = "src/test/resources/features/base1.feature",
        glue = {"com.epam.stepdefs"},
        format = {"pretty"})
@RunWith(Cucumber.class)
public class RunCukes1AutoTest {
}
