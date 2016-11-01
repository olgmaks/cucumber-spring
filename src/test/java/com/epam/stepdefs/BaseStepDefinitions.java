package com.epam.stepdefs;

import com.epam.restapi.TranslationResult;
import com.epam.restapi.YandexTranslator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

import javax.annotation.Resource;


public class BaseStepDefinitions {

    private final Logger log = Logger.getLogger(getClass());

    @Resource
    private YandexTranslator yandexTranslator;

    public static ThreadLocal<TranslationResult>
            translationResults = new ThreadLocal<>();

    @Given("^Set up YandexTranslator (\\w+) API$")
    public void setUp(String apiType) {
        log.info("Api type : => " + apiType);
    }

    @When("^Translate (\\w+) from (\\w+) to (\\w+)$")
    public void translate(String text, String fromLang, String toLang) {

        log.info(String.format("Translating text=[%s] from [%s] to [%s] ...", text, fromLang, toLang));
        translationResults.set(yandexTranslator.translate(fromLang + "-" + toLang, text));
    }

    @Then("^Expected translation should be (.+)$")
    public void expected(String text) {
        log.info(String.format("Asserting text=[%s]", text));
        Assert.assertEquals(translationResults.get().getText().get(0), text);
    }


}
