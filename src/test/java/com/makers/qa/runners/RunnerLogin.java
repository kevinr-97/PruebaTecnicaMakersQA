package com.makers.qa.runners;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/web/login.feature",
        glue = "com.makers.qa.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@smoke"
)

public class RunnerLogin {
}
