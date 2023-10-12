package com.inditex.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"com.inditex.stepdefinitions"},
        features = {"src/test/resources/features/getlistamascotas.feature"}
)
public class GetListaMascotas {
}
