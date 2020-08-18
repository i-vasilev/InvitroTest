package ru.vasilev.test.invitro.selectSection.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.vasilev.test.invitro.selectSection.Section;

@DefaultUrl("https://www.invitro.ru")
public class MainPage extends PageObject {
    @FindBy(css = "ul.header-top-nav")
    WebElementFacade ulMenu;

    public void clickMenuItem(Section itemName) {
        final WebElementFacade menuItem = ulMenu.findBy(By.xpath(String.format("//li[@class='header-top-nav__item']/a[@data-user='%s']", itemName.getValue())));
        menuItem.click();
    }
}
