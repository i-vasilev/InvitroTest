package ru.vasilev.test.invitro.selectSection.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ru.vasilev.test.invitro.selectSection.Section;
import ru.vasilev.test.invitro.selectSection.pages.MainPage;

public class SelectSectionSteps {
    MainPage mainPage = new MainPage();

    @Given("^user opens the site$")
    public void givenUserOpensTheSite() {
        mainPage.open();
    }


    @When("^select section (.*)$")
    public void selectSection(Section sectionName) {
        mainPage.clickMenuItem(sectionName);
    }
}
