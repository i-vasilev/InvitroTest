package ru.vasilev.test.invitro.findService.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.invitro.ru")
public class SearchPage extends PageObject {
    @FindBy(css = "input.search__input")
    WebElementFacade searchInput;

    @FindBy(css = "button.search__btn")
    WebElementFacade searchButton;

    public void inputToSearchField(String text) {
        searchInput.type(text);
    }
}
