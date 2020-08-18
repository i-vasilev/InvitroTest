package ru.vasilev.test.invitro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeCityTest {

    private ChromeDriver driver;

    @Test
    public void changeCityTest() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");

        final By locatorCity = By.cssSelector("div.city");
        final By locatorChangeCityButton = By.cssSelector(".city__change-btn");
        final By locatorCityInput = By.id("select-basket-city-input");
        final By locatorFoundCity = By.xpath("//div[@id='eac-container-select-basket-city-input']/ul/li");
        final By selectedCityName = By.cssSelector(".city__name.city__btn.city__name--label");

        driver = new ChromeDriver();
        driver.get("https://www.invitro.ru/radiology/");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementCity = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locatorCity, 0)).get(0);

        if (!elementCity.getCssValue("city--open").isEmpty()) {
            elementCity.click();
        }
        WebElement changeCityButton = wait.until(ExpectedConditions.elementToBeClickable(locatorChangeCityButton));
        changeCityButton.click();

        WebElement cityInput = driver.findElement(locatorCityInput);
        final String cityName = "Омск";
        cityInput.sendKeys(cityName);

        wait.until(ExpectedConditions.textMatches(locatorFoundCity, Pattern.compile(cityName)));
        WebElement foundCity = driver.findElement(locatorFoundCity);
        assertEquals(cityName, foundCity.getText().replaceAll("\n", ""));
        foundCity.click();

        wait.until(ExpectedConditions.textToBe(selectedCityName, cityName));
        driver.quit();
    }
}
