package ru.vasilev.test.invitro.findService.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ru.vasilev.test.invitro.findService.pages.SearchPage;

public class SearchScenarioSteps {
    SearchPage searchPage;

    @Given("^user opens the site$")
    public void givenUserOpensTheSite() {
        searchPage.open();
    }

    @When("^insert code (.*)$")
    public void insertCode(String code) {
        searchPage.inputToSearchField(code);
    }
}
