package ru.vasilev.test.invitro.findService;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/searchFeature.feature",
        glue = "ru.vasilev.test.invitro.findService")
public class SearchFeatureTest {
}
