package ru.vasilev.test.invitro.selectSection;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/selectSection.feature",
        glue = "ru.vasilev.test.invitro.selectSection")
public class SelectSectionTest {
}
